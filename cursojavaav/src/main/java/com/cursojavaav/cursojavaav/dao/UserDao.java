/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cursojavaav.cursojavaav.dao;

import com.cursojavaav.cursojavaav.models.User;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface UserDao {
    
    // Establece como debe ser la clase
    List<User> getUsers();

    void delete(Long id);

    User createUser(User user);
    
}
