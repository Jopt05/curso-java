/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursojavaav.cursojavaav.controllers;

import com.cursojavaav.cursojavaav.dao.UserDao;
import com.cursojavaav.cursojavaav.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
public class UsersController {
    
    @Autowired
    private UserDao usersDao;
    
    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> get() {
        return usersDao.getUsers();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    // Notacion para body
    public void post(@RequestBody User user) {
        usersDao.createUser(user);
        return;
    }
    
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        usersDao.delete(id);
        return "Eliminado correctamente";
    }
    
}
