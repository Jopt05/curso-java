/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursojavaav.cursojavaav.controllers;

import com.cursojavaav.cursojavaav.dao.UserDao;
import com.cursojavaav.cursojavaav.models.User;
import com.cursojavaav.cursojavaav.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jesús Puentes
 */
@RestController
public class AuthController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private JWTUtil jwtUtil;
    
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        User loggedUser = userDao.getUserByCredentials(user);
        if( loggedUser != null ) {
            String token = jwtUtil.create(String.valueOf(loggedUser.getId()), loggedUser.getEmail());
            return token;
        }
        return "Error";
    }
    
}
