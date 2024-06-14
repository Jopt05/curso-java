/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionfull.dao;

import com.mycompany.sistemagestionfull.models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ClienteDao {
    
    Connection conexion = null;
    
    public void conectar() {
        String baseDeDatos = "javacourse";
        String usuario = "root";
        String password = "";
        String hosting = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://" + hosting + ":" + puerto + "/" + baseDeDatos;
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(
                    conexionUrl,
                    usuario,
                    password
            );
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarCliente(Cliente client) {
        try {
            String sqlQuery = "INSERT INTO `clientes` (`name`, `lastname`, `email`, `phone`) VALUES\n" +
                    "('"+ client.getName() +"', '"+ client.getLastName() +"', '"+ client.getEmail() +"', '"+ client.getPhone() +"'); ";
            Statement statement = conexion.createStatement();
            statement.execute(sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Cliente> obtenerClientes() {
        List<Cliente> clientsList = new ArrayList<Cliente>();
        try {
            String sqlQuery = "SELECT * FROM `clientes`";
            Statement statement = conexion.createStatement();
            ResultSet results = statement.executeQuery(sqlQuery);
            
            while( results.next() ) {
                Cliente client = new Cliente();
                client.setName(results.getString("name"));
                client.setLastName(results.getString("lastname"));
                client.setEmail(results.getString("email"));
                client.setPhone(results.getString("phone"));
                client.setId(Integer.valueOf(results.getString("id")));
                clientsList.add(client);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientsList;
    }
    
    public void eliminarCliente(int id) {
        try {
            String sqlQuery = "DELETE FROM `clientes` WHERE id="+ id +";";
            Statement statement = conexion.createStatement();
            statement.execute(sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarCliente(Cliente client) {
        try {
            String sqlQuery = "UPDATE `clientes` " +
                    "SET name='"+ client.getName() +"', " +
                    "lastname='"+ client.getLastName() +"', " +
                    "email='"+ client.getEmail() +"', " +
                    "phone='"+ client.getPhone() +"' " +
                    "WHERE id='"+ client.getId() +"';";
            Statement statement = conexion.createStatement();
            statement.execute(sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
