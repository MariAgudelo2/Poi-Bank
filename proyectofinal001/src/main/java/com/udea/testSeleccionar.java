package com.udea;

import com.udea.dao.ClienteBancoDAO;
import com.udea.model.Cliente;

public class testSeleccionar {
    static String pais = "Argentina";
    static String contrasena = "vivaAnaGabriel";
    static int id = 123;

    static ClienteBancoDAO clienteDao = new ClienteBancoDAO();

    public static void main(String[] args) {
        Cliente cliente = clienteDao.seleccionarCliente(pais, id, contrasena);
        if (cliente != null) {
            System.out.println("hola " + cliente.getNombres() + " " + cliente.getApellidos());
        } else {
            System.out.println("Usuario o contraseña inválidos");
        }
    }
}
