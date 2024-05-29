package com.udea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import com.udea.model.ClienteInmo;

public class ClienteInmoDao {
    String URL_DB = "jdbc:mariadb://localhost:3306/mysql";
    String USER_DB = "root";
    String PASSWORD_DB = "root";
    Random ran = new Random();
    

    private static final String INSERTAR_CASA = " INSERT INTO inmo.inmocasas(idCliente, descripcion, tipo, pais, ciudad, metrosCuadrados, precio, fechalim, codigoProp) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SELECCIONAR_TODAS ="SELECT * FROM inmo.inmocasas ";
    private static final String SELECCIONAR_TODAS_SUBASTAS ="SELECT * FROM inmo.inmocasas where tipo like '%basta' ";
    private static final String SELECCIONAR_PROPDUEÑO ="SELECT * FROM inmo.inmocasas WHERE consecutivoInmo = ? ";
    private static final String SELECCIONAR_PROP ="SELECT * FROM inmo.inmocasas WHERE consecutivoInmo = ? AND descripcion = ?";
    private static final String MODIFICAR_DUEÑO = " UPDATE inmo.inmocasas SET consecutivoInmo= ?, idCliente= ?, tipo='Propiedad', fechalim= null WHERE consecutivoInmo = ? AND descripcion = ?" ;
    private static final String MODIFICAR_PRECIO = " UPDATE inmo.inmocasas SET precio= ? WHERE consecutivoInmo = ? AND descripcion = ?" ;
    private static final String ELIMINAR_PROPIEDAD = "DELETE FROM inmo.inmocasas WHERE consecutivoInmo = ? AND descripcion = ?";

                protected Connection getConnection() {
        Connection conexion = null;
        try {
          
          Class.forName("org.mariadb.jdbc.Driver");
          System.out.println("Conectando a la base de datos...");
          
          
          conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
          System.out.println(conexion);
        } catch (ClassNotFoundException e) {
          System.out.println("Error: MariaDB JDBC Driver no encontrado.");
        } catch (SQLException e) {
          System.out.println("Error al conectar a la base de datos: " + e.getMessage());
          e.printStackTrace();
        }
        return conexion;
    }


    public void InsertarCasa(ClienteInmo clienteInmo)
    {
        try (
            Connection conexion = getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_CASA)){
            preparedStatement.setInt(1, clienteInmo.getIdCliente());
            preparedStatement.setString(2, clienteInmo.getDescrip());
            preparedStatement.setString(3, clienteInmo.getTipo());
            preparedStatement.setString(4, clienteInmo.getPais());
            preparedStatement.setString(5, clienteInmo.getCiudad());
            preparedStatement.setString(6, clienteInmo.getMtsCua());
            preparedStatement.setDouble(7, clienteInmo.getPrecio());
            preparedStatement.setTimestamp(8, clienteInmo.getTimeStamp());
            preparedStatement.setInt(9, ran.nextInt(1000)+1);
            preparedStatement.executeUpdate();
            System.out.println("GOLEAMOSSSSSSSSSSS");
        } catch (Exception e) {
           System.out.println("Papi nos jodimos" + e.getMessage());
        }
    }

    public void ModificarDueño(ClienteInmo clienteInmo, ClienteInmo clienteInmo2)
    {
        try(
            Connection conexion = getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(MODIFICAR_DUEÑO)){
            preparedStatement.setInt(1, clienteInmo2.getConsecutivo());
            preparedStatement.setInt(2, clienteInmo2.getIdCliente());
            preparedStatement.setInt(3, clienteInmo.getConsecutivo());
            preparedStatement.setString(4, clienteInmo.getDescrip());
            
            // Imprimir los valores de los parámetros para verificación
        System.out.println("consecutivoInmo (nuevo): " + clienteInmo2.getConsecutivo());
        System.out.println("idCliente (nuevo): " + clienteInmo2.getIdCliente());
        System.out.println("consecutivoInmo (condición): " + clienteInmo.getConsecutivo());
        System.out.println("descripcion (condición): " + clienteInmo.getDescrip());
             // Ejecutar la actualización
        int rowsAffected = preparedStatement.executeUpdate();
        
        // Imprimir el número de filas afectadas para verificar que la actualización se realizó correctamente
        if (rowsAffected > 0) {
            System.out.println("La propiedad fue actualizada correctamente.");
        } else {
            System.out.println("No se encontraron registros que coincidan con los criterios proporcionados.");
        }
        } catch (Exception e) {
        System.out.println("No se cucho pille: " + e.getMessage());
        }
    }
    public void ModificarPrecio(Long valor, ClienteInmo clienteInmo)
    {
        try(
            Connection conexion = getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(MODIFICAR_PRECIO)){
              preparedStatement.setLong(1, valor);
              preparedStatement.setInt(2, clienteInmo.getConsecutivo());
              preparedStatement.setString(3, clienteInmo.getDescrip());
              preparedStatement.executeUpdate();

            } catch (Exception e) {
              System.out.println("Error mira: " +  e.getMessage());
            }
    }

    public ClienteInmo SeleccionarProp(int consecutivo, String desc)
    {   ClienteInmo clienteInmo = new ClienteInmo();
        try(
            Connection conexion = getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_PROP)){
            preparedStatement.setInt(1, consecutivo);
            preparedStatement.setString(2, desc);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                clienteInmo.setConsecutivo(resultSet.getInt("consecutivoInmo"));
                clienteInmo.setIdCliente(resultSet.getInt("idCliente"));
                clienteInmo.setDescrip(resultSet.getString("descripcion"));
                clienteInmo.setTipo(resultSet.getString("tipo"));
                clienteInmo.setPais(resultSet.getString("pais"));
                clienteInmo.setCiudad(resultSet.getString("ciudad"));
                clienteInmo.setMtsCua(resultSet.getString("metrosCuadrados"));
                clienteInmo.setPrecio(resultSet.getLong("precio"));  // Cambiar a double si el tipo en la BD es double
                clienteInmo.setTimeStamp(resultSet.getTimestamp("fechalim"));
                clienteInmo.setCodigoProp(resultSet.getInt("codigoPro"));
            } else {
                System.out.println("No se encontraron resultados para los parámetros proporcionados.");
            }
        } catch (Exception e) {
            System.out.println("aaaaa " + e.getMessage());
        }
        return clienteInmo;
    }

    public List<ClienteInmo> MostrarCasas() {

        List<ClienteInmo> clientesInmo = new ArrayList<>();

        try (Connection conexion = getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TODAS)) {
          ResultSet resultSet = preparedStatement.executeQuery();
          while (resultSet.next()) {
            ClienteInmo clienteInmo = new ClienteInmo();
            //clienteInmo.setNombre(resultSet.getString("consecutivoInmo"));
            clienteInmo.setIdCliente(resultSet.getInt("idCliente"));
            clienteInmo.setDescrip(resultSet.getString("descripcion"));
            clienteInmo.setTipo(resultSet.getString("tipo"));
            clienteInmo.setPais(resultSet.getString("pais"));
            clienteInmo.setCiudad(resultSet.getString("ciudad"));
            clienteInmo.setMtsCua(resultSet.getString("metrosCuadrados"));
            clienteInmo.setPrecio(resultSet.getLong("precio"));
            clienteInmo.setTimeStamp(resultSet.getTimestamp("fechalim"));
            clienteInmo.setCodigoProp(resultSet.getInt("codigoPro"));
            clientesInmo.add(clienteInmo);
          }
        } catch (SQLException e) {
          System.out.println("Error al seleccionar todas las casas: " + e.getMessage());
        }
        return clientesInmo;
      }

      public List<ClienteInmo> MostrarSubastas() {

        List<ClienteInmo> subastasDispo = new ArrayList<>();

        try (Connection conexion = getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TODAS_SUBASTAS)) {
          ResultSet resultSet = preparedStatement.executeQuery();
          while (resultSet.next()) {
            ClienteInmo clienteInmo = new ClienteInmo();
            //clienteInmo.setNombre(resultSet.getString("consecutivoInmo"));
            clienteInmo.setIdCliente(resultSet.getInt("idCliente"));
            clienteInmo.setDescrip(resultSet.getString("descripcion"));
            clienteInmo.setTipo(resultSet.getString("tipo"));
            clienteInmo.setPais(resultSet.getString("pais"));
            clienteInmo.setCiudad(resultSet.getString("ciudad"));
            clienteInmo.setMtsCua(resultSet.getString("metrosCuadrados"));
            clienteInmo.setPrecio(resultSet.getLong("precio"));
            clienteInmo.setTimeStamp(resultSet.getTimestamp("fechalim"));
            subastasDispo.add(clienteInmo);
          }
        } catch (SQLException e) {
          System.out.println("Error al seleccionar todas las propiedades en subasta: " + e.getMessage());
        }
        return subastasDispo;
      }

      public  void eliminarPropiedad(int consecutivoInmo, String descString)
      {
        try (
            Connection conexion = getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(ELIMINAR_PROPIEDAD)){
            preparedStatement.setInt(1, consecutivoInmo);
            preparedStatement.setString(2, descString);  
            preparedStatement.executeUpdate();
            System.out.println("Ah no chao");
        } catch (Exception e) {
           System.out.println("Papi nos jodimos" + e.getMessage());
        }
      }
}
