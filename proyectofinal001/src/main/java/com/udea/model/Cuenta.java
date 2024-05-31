package com.udea.model;

import com.udea.model.Cliente;

public class Cuenta {
    private int consecutivo;
    private int nroCuenta;
    private double saldo = 0;
    private Cliente cliente;
    private String tipoCuenta;
    private String estado = "activa";

    public Cuenta(int nroCuenta, Cliente cliente, String tipoCuenta) {
        this.nroCuenta = nroCuenta;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
    }

    public Cuenta() {

    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
