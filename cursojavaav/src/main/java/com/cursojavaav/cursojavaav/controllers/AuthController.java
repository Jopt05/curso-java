/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursojavaav.cursojavaav.controllers;

import com.cursojavaav.cursojavaav.models.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jesús Puentes
 */
public class AuthController {
    
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public void login(@RequestBody User user) {
        
    }
    
}
