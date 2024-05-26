package com.udea;

import com.udea.dao.ClienteDAO;
import com.udea.model.Cliente;

//Para probar la clase conection con datos quemados y ver si llega hasta la base de datos

public class TestInsertarBD {
    static ClienteDAO clienteDao = new ClienteDAO();
    static Cliente nuevoCliente = new Cliente(123, "pepito", "perez", "pepito.perez@yahoo.com", "argentina",
            "pepitoelmejor");

    public static void main(String[] args) {
        clienteDao.insertarCliente(nuevoCliente);
    }
}
