/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursojavaav.cursojavaav.dao;

import com.cursojavaav.cursojavaav.models.User;
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
    
}
