package com.udea.model;

public class Transacciones {
    private int consecutivo;
    private int cuenta;
    private String tipoTransaccion;
    private double monto;
    private String fecha;
    private String hora;

    public Transacciones(int cuenta, String tipoTransaccion, double monto, String fecha, String hora) {
        this.cuenta = cuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Transacciones() {

    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean consignar(Cuenta cuenta, double monto) {
        double saldo = cuenta.getSaldo();
        double comision = monto * 0.01;
        if (monto < 50000) {
            comision = 100;
        }
        if (monto > 0 && cuenta.getEstado().equals("activa")) {
            cuenta.setSaldo(saldo + monto - comision);
            return true;
        } else {
            return false;
        }

    }

    public boolean retirar(Cuenta cuenta, double monto) {
        double saldo = cuenta.getSaldo();
        double comision = monto * 0.01;
        if (monto < 50000) {
            comision = 100;
        }
        double valor = monto + comision;
        if (saldo >= valor && valor > 0 && cuenta.getEstado().equals("activa")) {
            cuenta.setSaldo(saldo - valor);
            return true;
        } else {
            return false;
        }
    }

    public double conversionMoneda(double valor, String moneda) {
        double monto = 0;
        if (moneda.equals("USD ($)")) {
            monto = valor * 3856.15;
        } else if (moneda.equals("EUR (€)")) {
            monto = valor * 4193.93;
        } else if (moneda.equals("COP ($)")) {
            monto = valor;
        }
        System.out.println(monto);
        return monto;
    }

}
