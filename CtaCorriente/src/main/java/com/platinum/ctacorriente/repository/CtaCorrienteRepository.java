/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platinum.ctacorriente.repository;

/**
 *
 * @author anahr
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.platinum.ctacorriente.model.CtaCorriente;

public class CtaCorrienteRepository {
    private final Connection connection;

    public CtaCorrienteRepository(Connection connection) {
        this.connection = connection;
    }

    public void agregarCtaCorriente(CtaCorriente ctaCorriente) throws SQLException {
        String query = "INSERT INTO CtaCorriente (rutCliente, monto, ejecutivo) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, ctaCorriente.getRutCliente());
            preparedStatement.setBigDecimal(2, ctaCorriente.getMonto());
            preparedStatement.setString(3, ctaCorriente.getEjecutivo());

            preparedStatement.executeUpdate();
        }
    }

    public CtaCorriente obtenerCtaCorrientePorId(int idCuenta) throws SQLException {
        String query = "SELECT * FROM CtaCorriente WHERE idCuenta = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idCuenta);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    CtaCorriente ctaCorriente = new CtaCorriente();
                    ctaCorriente.setIdCuenta(resultSet.getInt("idCuenta"));
                    ctaCorriente.setRutCliente(resultSet.getString("rutCliente"));
                    ctaCorriente.setMonto(resultSet.getBigDecimal("monto"));
                    ctaCorriente.setEjecutivo(resultSet.getString("ejecutivo"));

                    return ctaCorriente;
                } else {
                    return null;
                }
            }
        }
    }

    // Otros métodos según las operaciones necesarias (actualizar, eliminar, obtener todos, etc.)
}