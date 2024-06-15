/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursojavaav.cursojavaav.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Lenovo
 */

@Entity
@Table(name = "users")
@ToString @EqualsAndHashCode
public class User {
    
    // Esto es de Lombok
    @Getter @Setter @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Getter @Setter @Column(name = "name")
    private String name;
    
    @Getter @Setter @Column(name = "last_name")
    private String lastName;
    
    @Getter @Setter @Column(name = "email")
    private String email;
    
    @Getter @Setter @Column(name = "phone")
    private String phone;
    
    @Getter @Setter @Column(name = "password")
    private String password;
    
}
