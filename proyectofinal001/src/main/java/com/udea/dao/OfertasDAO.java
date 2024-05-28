package com.udea.dao;

public class OfertasDAO {

    String URL_DB = "jdbc:mariadb://localhost:3306/mysql";
    String USER_DB = "root";
    String PASSWORD_DB = "root";

    private static final String SELECCIONAR_COMPRADOR ="SELECT consecutivoVendedor FROM inmo.ofertas WHERE oferta = ?";
}
