package com.udea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.udea.model.Cliente;
import com.udea.model.Cuenta;

public class ClienteBancoDAO {
    ConexionDAO conexionDao = new ConexionDAO();
    //banco.cuentas
    private static final String insertarCliente = "INSERT INTO inmo.clientesb (id, nombres, apellidos, email, pais, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String seleccionarCliente = "SELECT * FROM inmo.clientesb WHERE pais = ? AND id = ? AND contrasena = ?";
    private static final String crearCuenta = "INSERT INTO inmo.clientesb (nroCuenta, cliente, saldo, tipoCuenta) VALUES (?, ?, ?, ?)";
    private static final String seleccionarCuenta = "SELECT * FROM inmo.clientesb WHERE cliente = ? AND tipoCuenta = ?";
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
                cliente.setConsecutivo(resultSet.getInt("consecutivo"));
                cliente.setId(resultSet.getInt("id"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setContrasena(resultSet.getString("contrasena"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar un cliente: " + e.getMessage());
        }
        return cliente;
    }

    public void crearCuenta(Cuenta cuenta) {
        try (
                Connection conexion = conexionDao.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(crearCuenta)) {
            preparedStatement.setInt(1, cuenta.getNroCuenta());
            preparedStatement.setInt(2, (cuenta.getCliente()).getConsecutivo());
            preparedStatement.setDouble(3, 0);
            preparedStatement.setString(4, cuenta.getTipoCuenta());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al crear una cuenta: " + e.getMessage());
        }
    }

    public Cuenta seleccionarCuenta(Cliente cliente, String tipoCuenta) {
        Cuenta cuenta = null;
        try (
                Connection conexion = conexionDao.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(seleccionarCuenta)) {
            preparedStatement.setInt(1, cliente.getConsecutivo());
            preparedStatement.setString(2, tipoCuenta);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cuenta = new Cuenta();
                cuenta.setSaldo(resultSet.getDouble("saldo"));
                cuenta.setNroCuenta(resultSet.getInt("nroCuenta"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar una cuenta: " + e.getMessage());
        }
        return cuenta;
    }

    public ClienteBancoDAO() {
    }

}
