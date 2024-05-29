package com.udea;

import com.udea.dao.ClienteBancoDAO;
import com.udea.model.Cliente;
import com.udea.model.Cuenta;

public class testCrearCuenta {
    static ClienteBancoDAO clienteDao = new ClienteBancoDAO();
    static Cliente cliente = clienteDao.seleccionarCliente("Argentina", 123, "pepitoelmejor");
    static Cuenta cuenta = new Cuenta(123456789, cliente, "ahorros");

    public static void main(String[] args) {
        clienteDao.crearCuenta(cuenta);
        System.out.println(clienteDao.seleccionarCuenta(cliente, "ahorros").getNroCuenta());
    }
}
