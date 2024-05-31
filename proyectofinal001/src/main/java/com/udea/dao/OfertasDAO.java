package com.udea.dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import com.udea.model.ClienteInmo;

public class OfertasDAO {

    static ConexionDAO conexionDAO = new ConexionDAO();
    String URL_DB = "jdbc:mariadb://localhost:3306/mysql";
    String USER_DB = "root";
    String PASSWORD_DB = "root";
    Random ran = new Random();
    
    static ClienteInmoDao clienteInmoDao = new ClienteInmoDao();
    private static final String SELECCIONAR_COMPRADOR ="SELECT consecutivoVendedor FROM inmo.ofertas WHERE oferta = ?";
    private static final String INSERTAR_CASA = " INSERT INTO inmo.inmocasas(idCliente, descripcion, tipo, pais, ciudad, metrosCuadrados, precio, fechalim, codigoPro) VALUES(?,?,?,?,?,?,?,?,?)";

    public void InsertarPropiedad( int id, String descri , String pais, String ciudad, String mts , Long precio, java.sql.Timestamp fecha)
    {
        try (
            
            Connection conexion = conexionDAO.getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_CASA)){
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, descri);
            preparedStatement.setString(3, "Subasta");
            preparedStatement.setString(4, pais);
            preparedStatement.setString(5, ciudad);
            preparedStatement.setString(6, mts);
            preparedStatement.setDouble(7, precio);
            preparedStatement.setTimestamp(8, fecha);
            preparedStatement.setInt(9, ran.nextInt(1000)+1);
            preparedStatement.executeUpdate();
            System.out.println("GOLEAMOSSSSSSSSSSS");
        } catch (Exception e) {
           System.out.println("Papi nos jodimos" + e.getMessage());
        }
    }
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
