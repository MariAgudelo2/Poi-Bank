package com.udea;

import java.util.List;

import com.udea.dao.ClienteBancoDAO;
import com.udea.model.Cliente;
import com.udea.model.Cuenta;

public class TestSeleccionar {
    static String pais = "Argentina";
    static String contrasena = "pepitoelmejor";
    static int id = 123;

    static ClienteBancoDAO clienteDao = new ClienteBancoDAO();

    public static void main(String[] args) {
        Cliente cliente = clienteDao.seleccionarCliente(pais, id, contrasena);
        if (cliente != null) {
            System.out.println("hola " + cliente.getNombres() + " " + cliente.getApellidos());
        } else {
            System.out.println("Usuario o contraseña inválidos");
        }
        List<Cuenta> cuentas = clienteDao.mostrarCuentas(cliente);
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.getTipoCuenta());
            System.out.println(cuenta.getNroCuenta());
        }
        conversionMoneda(10, "dolares");
    }

    public static double conversionMoneda(double valor, String tipo) {
        double monto = valor;
        if (tipo == "dolares") {
            monto = valor * 3856.15;
        } else if (tipo == "euros") {
            monto = valor * 4193.93;
        }
        System.out.println(monto);
        return monto;
    }
}
