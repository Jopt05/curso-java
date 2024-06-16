/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursojavaav.cursojavaav.controllers;

import com.cursojavaav.cursojavaav.dao.UserDao;
import com.cursojavaav.cursojavaav.models.User;
import com.cursojavaav.cursojavaav.utils.JWTUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    
    @Autowired
    private JWTUtil jwtUtil;
    
    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> get(
            @RequestHeader(value="Authorization") String token
    ) {
        String tokenValue = jwtUtil.getValue(token);
        System.out.println("Token value");
        System.out.println(tokenValue);
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
