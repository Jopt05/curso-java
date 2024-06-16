/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursojavaav.cursojavaav.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author Lenovo
 */
@Data
public class LoginDto {
    
    @NotBlank(message="Email is required")
    public String email;
    
    @NotBlank(message="Password is required")
    public String password;
    
}
