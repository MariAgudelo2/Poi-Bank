package com.udea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.udea.model.Cliente;

public class ClienteDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/mysql";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";

    private static final String INSERTAR_USUARIO = "INSERT INTO clientes (identificacion, nombre1, nombre2, apellido1, apellido2, email) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECCIONAR_USUARIO_CEDULA = "SELECT * FROM clientes WHERE identificacion = ?";
    private static final String SELECCIONAR_TODOS = "SELECT * FROM clientes";
    private static final String ELIMINAR_USUARIO = "DELETE FROM clientes WHERE identificacion = ?";
    private static final String ACTUALIZAR_USUARIO = "UPDATE clientes SET nombre1 = ?, nombre2 = ?, apellido1 = ?, apellido2 = ?, email = ? WHERE identificacion = ?";

    protected Connection getConnection() {
        Connection conexion = null;
        try {
            // Importante esta línea para que el driver sepa que se va a conectar a una base
            // de datos MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Conectando a la base de datos...");
            // Le pasamos la URL de la base de datos, el usuario y la contraseña para
            // conectarnos a la base de datos
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

    public void insertarUsuario(Cliente nuevoCliente) {
        try (
                Connection conexion = getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_USUARIO)) {
            preparedStatement.setInt(1, nuevoCliente.getIdentificacion());
            preparedStatement.setString(2, nuevoCliente.getNombre1());
            preparedStatement.setString(3, nuevoCliente.getNombre2());
            preparedStatement.setString(4, nuevoCliente.getApellido1());
            preparedStatement.setString(5, nuevoCliente.getApellido2());
            preparedStatement.setString(6, nuevoCliente.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar un usuario: " + e.getMessage());
        }
    }

    // Se retorna un solo usuario por eso Cliente que es el objeto/modelo que se va
    // a retornar
    public Cliente seleccionarUsuarioPorCedula(int cedula) {
        Cliente usuario = null;
        try (Connection conexion = getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_USUARIO_CEDULA)) {
            preparedStatement.setInt(1, cedula);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usuario = new Cliente();
                usuario.setIdentificacion(resultSet.getInt("identificacion"));
                usuario.setNombre1(resultSet.getString("nombre1"));
                usuario.setNombre2(resultSet.getString("nombre2"));
                usuario.setApellido1(resultSet.getString("apellido1"));
                usuario.setApellido2(resultSet.getString("apellido2"));
                usuario.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar un usuario por cédula: " + e.getMessage());
        }
        return usuario;
    }

}
