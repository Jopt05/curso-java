/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemagestionfull;

import com.mycompany.sistemagestionfull.dao.ClienteDao;
import com.mycompany.sistemagestionfull.forms.ClientsForm;

/**
 *
 * @author Lenovo
 */
public class SistemaGestionFull {

    public static void main(String[] args) {
        ClienteDao database = new ClienteDao();
        database.conectar();
        ClientsForm form = new ClientsForm(database);
        form.show();
    }
}
