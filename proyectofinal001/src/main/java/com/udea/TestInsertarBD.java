package com.udea;

import com.udea.dao.ClienteBancoDAO;
import com.udea.model.Cliente;

//Para probar la clase conection con datos quemados y ver si llega hasta la base de datos

public class TestInsertarBD {
    static ClienteBancoDAO clienteDao = new ClienteBancoDAO();
    static Cliente nuevoCliente = new Cliente(123, "pepita", "lopez", "pepita.lopez@yahoo.com", "colombia",
            "vivaAnaGabriel");

    public static void main(String[] args) {
        clienteDao.insertarCliente(nuevoCliente);
    }
}
