package com.udea.model;

import java.sql.Timestamp;

public class ClienteInmo {

    private int consecutivo;
    private int idCliente;
    private String descrip;
    private String pais;
    private String ciudad;
    private String mtsCua;
    private Long precio;
    private String tipo;
    private Timestamp timeStamp;

    public int getConsecutivo() {
        return consecutivo;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getDescrip() {
        return descrip;
    }
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getMtsCua() {
        return mtsCua;
    }
    public void setMtsCua(String mtsCua) {
        this.mtsCua = mtsCua;
    }
    public Long getPrecio() {
        return precio;
    }
    public void setPrecio(Long precio) {
        this.precio = precio;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Timestamp getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    







}