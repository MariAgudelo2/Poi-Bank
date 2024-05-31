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

    public boolean consignar_retirar(String tipoTransaccion, Cuenta cuenta, double monto) {
        try (
                Connection conexion = conexionDao.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(hacerTransaccion)) {

            LocalDate fecha = LocalDate.now();
            LocalTime hora = LocalTime.now();
            Boolean transaccion = false;

            switch (tipoTransaccion) {
                case "consignar":
                    transaccion = trans.consignar(cuenta, monto);
                    break;
                case "retirar":
                    transaccion = trans.retirar(cuenta, monto);
                    break;
                default:
                    break;
            }
            if (!transaccion) {
                System.out.println("saldo insuficiente o monto inválido");
                return false;
            }
            preparedStatement.setInt(1, cuenta.getNroCuenta());
            preparedStatement.setString(2, tipoTransaccion);
            preparedStatement.setDouble(3, monto);
            preparedStatement.setString(4, fecha.toString());
            preparedStatement.setString(5, hora.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar la transacción: " + e.getMessage());
        }
        return true;
    }

    public void transferir(String tipoTransaccion, Cuenta cuentaSalida, Cuenta cuentaEntrada, double monto) {
        try (
                Connection conexion = conexionDao.getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(hacerTransaccion)) {

            LocalDate fecha = LocalDate.now();
            LocalTime hora = LocalTime.now();

            trans.transferir(cuentaSalida, cuentaEntrada, monto);

            if (!trans.transferir(cuentaSalida, cuentaEntrada, monto)) {
                System.out.println("saldo insuficiente o monto inválido");
            }
            preparedStatement.setInt(1, cuentaSalida.getNroCuenta());
            preparedStatement.setString(2, tipoTransaccion);
            preparedStatement.setDouble(3, monto);
            preparedStatement.setString(4, fecha.toString());
            preparedStatement.setString(5, hora.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar la transacción: " + e.getMessage());
        }
    }
}
