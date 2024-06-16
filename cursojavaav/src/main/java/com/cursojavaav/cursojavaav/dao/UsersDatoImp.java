/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursojavaav.cursojavaav.dao;

import com.cursojavaav.cursojavaav.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lenovo
 */
@Repository
@Transactional
public class UsersDatoImp implements UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        // Hacela conslta en Hibernate
        String query = "FROM User";
        List<User> results = entityManager.createQuery(query).getResultList();
        return results;
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User createUser(User user) {
        Argon2 argonClient = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argonClient.hash(
                1, 
                1024, 
                1, 
                user.getPassword()
        );
        user.setPassword(hash);
        entityManager.merge(user);
        return user;
    }

    @Override
    public boolean verifyAuth(User user) {
        //Al hacer éste ejercicio de reemplazar parámetros
        //evitamos inyección de SQL
        String query = "FROM User WHERE email = :email AND password = :password";
        List<User> usersList = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();
        
        String passwordHashed = usersList.get(0).getPassword();
        
        Argon2 argonClient = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        boolean isCorrect = argonClient.verify(passwordHashed, user.getPassword());
        
        return isCorrect;
    }
       
}
