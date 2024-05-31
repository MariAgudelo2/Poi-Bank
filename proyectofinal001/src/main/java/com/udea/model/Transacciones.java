package com.udea.model;

public class Transacciones {

    public boolean consignar(Cuenta cuenta, double monto) {
        double saldo = cuenta.getSaldo();
        if (monto > 0 && cuenta.getEstado().equals("activa")) {
            cuenta.setSaldo(saldo + monto);
            return true;
        } else {
            return false;
        }

    }

    public boolean transferir(Cuenta cuentaSalida, Cuenta cuentaEntrada, double monto) {
        double saldo1 = cuentaSalida.getSaldo();
        double saldo2 = cuentaEntrada.getSaldo();
        if (saldo1 >= monto && monto > 0 && cuentaSalida.getEstado() == "activa"
                && cuentaEntrada.getEstado() == "activa") {
            cuentaSalida.setSaldo(saldo1 - monto);
            cuentaEntrada.setSaldo(saldo2 + monto);
            return true;
        } else {
            return false;
        }
    }

    public boolean retirar(Cuenta cuenta, double monto) {
        double saldo = cuenta.getSaldo();
        if (saldo >= monto && monto > 0 && cuenta.getEstado() == "activa") {
            cuenta.setSaldo(saldo - monto);
            return true;
        } else {
            return false;
        }
    }

    public double conversionMoneda(double valor, String tipo) {
        double monto = 0;
        if (tipo == "dolares") {
            monto = valor * 3856.15;
        } else if (tipo == "euros") {
            monto = valor * 4193.93;
        } else if (tipo == "pesos") {
            monto = valor;
        }
        return monto;
    }
}
