package com.udea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.udea.model.Cliente;

public class ClienteBancoDAO {
    conexionDAO conexionDao = new conexionDAO();

    private static final String insertarCliente = "INSERT INTO banco.clientes (id, nombres, apellidos, email, pais, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String seleccionarCliente = "SELECT * FROM banco.clientes WHERE pais = ? AND id = ? AND contrasena = ?";
    private static final String ELIMINAR_cliente = "DELETE FROM clientes WHERE identificacion = ?";
    private static final String ACTUALIZAR_cliente = "UPDATE clientes SET nombre1 = ?, nombre2 = ?, apellido1 = ?, apellido2 = ?, email = ?, contrasena = ? WHERE identificacion = ?";

    public void insertarCliente(Cliente nuevoCliente) {
        try (
                Connection conexion = conexionDao.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(insertarCliente)) {
            preparedStatement.setInt(1, nuevoCliente.getId());
            preparedStatement.setString(2, nuevoCliente.getNombres());
            preparedStatement.setString(3, nuevoCliente.getApellidos());
            preparedStatement.setString(4, nuevoCliente.getEmail());
            preparedStatement.setString(5, nuevoCliente.getPais());
            preparedStatement.setString(6, nuevoCliente.getContrasena());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar un cliente: " + e.getMessage());
        }
    }

    public Cliente seleccionarCliente(String pais, int id, String contrasena) {
        Cliente cliente = null;
        try (
                Connection conexion = conexionDao.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(seleccionarCliente)) {
            preparedStatement.setString(1, pais);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, contrasena);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setNombres(resultSet.getString("nombres"));
                cliente.setApellidos(resultSet.getString("apellidos"));
                cliente.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar un cliente: " + e.getMessage());
        }
        return cliente;
    }

    public ClienteBancoDAO() {
    }

}
