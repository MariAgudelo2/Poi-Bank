package com.udea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.udea.model.Cliente;

public class ClienteDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/mysql";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";

    private static final String INSERTAR_cliente = "INSERT INTO clientes (identificacion, nombre1, nombre2, apellido1, apellido2, email) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECCIONAR_cliente_IDENTIFICACION = "SELECT * FROM clientes WHERE identificacion = ?";
    private static final String SELECCIONAR_TODOS = "SELECT * FROM clientes";
    private static final String ELIMINAR_cliente = "DELETE FROM clientes WHERE identificacion = ?";
    private static final String ACTUALIZAR_cliente = "UPDATE clientes SET nombre1 = ?, nombre2 = ?, apellido1 = ?, apellido2 = ?, email = ? WHERE identificacion = ?";

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

    public void insertarcliente(Cliente nuevoCliente) {
        try (
                Connection conexion = getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_cliente)) {
            preparedStatement.setInt(1, nuevoCliente.getIdentificacion());
            preparedStatement.setString(2, nuevoCliente.getNombre1());
            preparedStatement.setString(3, nuevoCliente.getNombre2());
            preparedStatement.setString(4, nuevoCliente.getApellido1());
            preparedStatement.setString(5, nuevoCliente.getApellido2());
            preparedStatement.setString(6, nuevoCliente.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar un cliente: " + e.getMessage());
        }
    }

    public Cliente seleccionarClientePorIdentificacion(int identificacion) {
        Cliente cliente = null;
        try (Connection conexion = getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_cliente_IDENTIFICACION)) {
            preparedStatement.setInt(1, identificacion);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setIdentificacion(resultSet.getInt("identificacion"));
                cliente.setNombre1(resultSet.getString("nombre1"));
                cliente.setNombre2(resultSet.getString("nombre2"));
                cliente.setApellido1(resultSet.getString("apellido1"));
                cliente.setApellido2(resultSet.getString("apellido2"));
                cliente.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar el cliente" + e.getMessage());
        }
        return cliente;
    }

}
