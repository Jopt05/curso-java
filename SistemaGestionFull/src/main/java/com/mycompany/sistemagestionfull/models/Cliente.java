/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionfull.models;

/**
 *
 * @author Lenovo
 */
public class Cliente {
    
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String phone;

    public int getId() {
        return id;
    }
    
    public void setId(int value) {
        id = value;
    }
    
    public void setName(String value) {
        name = value;
    }
    
    public void setLastName(String value) {
        lastName = value;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        return name + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
