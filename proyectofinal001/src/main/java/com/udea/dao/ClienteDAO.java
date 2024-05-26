package com.udea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.udea.model.Cliente;

public class ClienteDAO {
    conexionDAO conexionDao = new conexionDAO();
    Connection conexion = conexionDao.getConnection();

    private static final String añadirCliente = "INSERT INTO clientes (id, nombres, apellidos, email, pais) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECCIONAR_cliente_IDENTIFICACION = "SELECT * FROM clientes WHERE identificacion = ?";
    private static final String SELECCIONAR_TODOS = "SELECT * FROM clientes";
    private static final String ELIMINAR_cliente = "DELETE FROM clientes WHERE identificacion = ?";
    private static final String ACTUALIZAR_cliente = "UPDATE clientes SET nombre1 = ?, nombre2 = ?, apellido1 = ?, apellido2 = ?, email = ? WHERE identificacion = ?";

    public void insertarcliente(Cliente nuevoCliente) {
        try (
                PreparedStatement preparedStatement = conexion.prepareStatement(añadirCliente)) {
            preparedStatement.setInt(1, nuevoCliente.getId());
            preparedStatement.setString(2, nuevoCliente.getNombres());
            preparedStatement.setString(4, nuevoCliente.getApellidos());
            preparedStatement.setString(6, nuevoCliente.getEmail());
            preparedStatement.setString(5, nuevoCliente.getPais());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar un cliente: " + e.getMessage());
        }
    }

    public ClienteDAO() {
    }

}
