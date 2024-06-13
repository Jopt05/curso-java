/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jesús Puentes
 */
public class Mavenproject1 {
    public static void main(String[] args) throws IOException {
        Integer numero1 = cargarNumero();
        Integer numero2 = cargarNumero();
        Integer numero3 = cargarNumero();
        
        //Usando la función
        //calcularNumeroMayor(numero1, numero2, numero3);
        //calcularNumeroMenor(numero1, numero2, numero3);
        Double promedio = calcularPromedio(
                numero1,
                numero2,
                numero3
        );
        
        System.out.println(promedio);
    }
    
    // Mira el throw
    private static Integer cargarNumero() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        
        System.out.println("Ingrese el número:");
        String strNumero1 = reader.readLine();
        Integer numero1 = Integer.parseInt(strNumero1);
        return numero1;
    }
    
    // El tercer argumento (void) indica que retorna esa función
    private static void calcularNumeroMayor(Integer numero1, Integer numero2, Integer numero3) {
        Integer mayor = numero1;
        
        if( numero2 > mayor ) {
            mayor = numero2;
        }
        if( numero3 > mayor ) {
            mayor = numero3;
        }
        
        System.out.println("El número mayor es: " + mayor);
    }
    
    private static void calcularNumeroMenor(Integer numero1, Integer numero2, Integer numero3) {
        
        Integer menor = numero1;
        
        if( numero2 < menor ) {
            menor = numero2;
        }
        if( numero3 < menor ) {
            menor = numero3;
        }
        System.out.println("El número menor es: " + menor);
    }
    
    private static Double calcularPromedio(Integer numero1, Integer numero2, Integer numero3) {
        Integer sumatoria = numero1 + numero2 + numero3;
        return Double.valueOf(sumatoria / 3);
    }
}
