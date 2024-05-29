package com.udea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.udea.model.ClienteInmo;

public class OfertasDAO {

    static ConexionDAO conexionDAO = new ConexionDAO();
    String URL_DB = "jdbc:mariadb://localhost:3306/mysql";
    String USER_DB = "root";
    String PASSWORD_DB = "root";
    static ClienteInmoDao clienteInmoDao = new ClienteInmoDao();
    private static final String SELECCIONAR_COMPRADOR ="SELECT consecutivoVendedor FROM inmo.ofertas WHERE oferta = ?";


    public static ClienteInmo SeleccionarComprador(Long oferta)
    {
        ClienteInmo comprador = new ClienteInmo();
        try (
           
            Connection conexion = conexionDAO.getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_COMPRADOR)){
            preparedStatement.setLong(0, oferta);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

               comprador = clienteInmoDao.SeleccionarProp(resultSet.getInt(1), "compradorxd");
              
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return comprador;
    }
        
}
