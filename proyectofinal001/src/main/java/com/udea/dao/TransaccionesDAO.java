package com.udea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.udea.model.*;

public class TransaccionesDAO {
    ConexionDAO conexionDao = new ConexionDAO();
    Transacciones trans = new Transacciones();

    private static final String hacerTransaccion = "INSERT INTO banco.transacciones (cuenta, tipoTransaccion, monto, fecha, hora) VALUES (?, ?, ?, ?, ?)";
    private static final String updateSaldo = "UPDATE banco.cuentas SET saldo = ? WHERE nroCuenta = ?";
    private static final String mostrarMovimientos = "SELECT * FROM banco.transacciones WHERE cuenta = ?";

    public boolean consignar(Cuenta cuenta, double valor, String moneda) {
        try (
                Connection conexion = conexionDao.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(hacerTransaccion)) {

            LocalDate fecha = LocalDate.now();
            LocalTime hora = LocalTime.now();
            double monto = trans.conversionMoneda(valor, moneda);
            Boolean transaccion = trans.consignar(cuenta, monto);

            if (transaccion == false) {
                System.out.println("saldo insuficiente o monto inválido");
                return false;
            }
            preparedStatement.setInt(1, cuenta.getNroCuenta());
            preparedStatement.setString(2, "consignar");
            preparedStatement.setDouble(3, monto);
            preparedStatement.setString(4, fecha.toString());
            preparedStatement.setString(5, hora.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar la transacción: " + e.getMessage());
        }
        return true;
    }

    public boolean retirar(Cuenta cuenta, double monto) {
        try (
                Connection conexion = conexionDao.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(hacerTransaccion)) {

            LocalDate fecha = LocalDate.now();
            LocalTime hora = LocalTime.now();
            Boolean transaccion = trans.retirar(cuenta, monto);

            if (transaccion == false) {
                System.out.println("saldo insuficiente o monto inválido");
                return false;
            }
            preparedStatement.setInt(1, cuenta.getNroCuenta());
            preparedStatement.setString(2, "retirar");
            preparedStatement.setDouble(3, monto);
            preparedStatement.setString(4, fecha.toString());
            preparedStatement.setString(5, hora.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar la transacción: " + e.getMessage());
        }
        return true;
    }

    public List<Transacciones> mostrarMovimientos(Cuenta cuenta) {
        List<Transacciones> transacciones = new ArrayList<>();
        try (Connection conexion = conexionDao.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(mostrarMovimientos)) {
            preparedStatement.setInt(1, cuenta.getNroCuenta());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Transacciones trans = new Transacciones();
                trans.setConsecutivo(resultSet.getInt("consecutivo"));
                trans.setCuenta(resultSet.getInt("cuenta"));
                trans.setTipoTransaccion(resultSet.getString("tipoTransaccion"));
                trans.setMonto(resultSet.getDouble("monto"));
                trans.setFecha(resultSet.getString("fecha"));
                trans.setHora(resultSet.getString("hora"));
                transacciones.add(trans);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar cuentas: " + e.getMessage());
        }
        return transacciones;
    }

    public void actualizarSaldo(Double saldo, int nroCuenta) {
        try (
                Connection conexion = conexionDao.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(updateSaldo)) {
            preparedStatement.setDouble(1, saldo);
            preparedStatement.setInt(2, nroCuenta);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar saldo: " + e.getMessage());
        }

    }
}
