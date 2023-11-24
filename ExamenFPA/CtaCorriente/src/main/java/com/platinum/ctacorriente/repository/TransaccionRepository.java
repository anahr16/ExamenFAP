/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platinum.ctacorriente.repository;

/**
 *
 * @author anahr
 */
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.platinum.ctacorriente.model.Transaccion;

public class TransaccionRepository {

    private final Connection connection;

    // Configurar y manejar la conexión a la base de datos
    public TransaccionRepository(Connection connection) {
        this.connection = connection;
    }

    public void agregarTransaccion(Transaccion transaccion) throws SQLException {
        String query = "INSERT INTO Transaccion (id, rutCliente, rutDueno, idCuenta, montoTransferencia, cuentaTransferencia, tipoCuenta) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, transaccion.getId());
            preparedStatement.setString(2, transaccion.getRutCliente());
            preparedStatement.setString(3, transaccion.getRutDueno());
            preparedStatement.setInt(4, transaccion.getIdCuenta());
            preparedStatement.setBigDecimal(5, transaccion.getMontoTransferencia());
            preparedStatement.setString(6, transaccion.getCuentaTransferencia());
            preparedStatement.setString(7, transaccion.getTipoCuenta());

            preparedStatement.executeUpdate();
        }
    }

    public Transaccion obtenerTransaccionPorId(int id) throws SQLException {
        String query = "SELECT * FROM Transaccion WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Transaccion transaccion = new Transaccion();
                    transaccion.setId(resultSet.getInt("id"));
                    transaccion.setRutCliente(resultSet.getString("rutCliente"));
                    transaccion.setRutDueno(resultSet.getString("rutDueno"));
                    transaccion.setIdCuenta(resultSet.getInt("idCuenta"));
                    transaccion.setMontoTransferencia(resultSet.getBigDecimal("montoTransferencia"));
                    transaccion.setCuentaTransferencia(resultSet.getString("cuentaTransferencia"));
                    transaccion.setTipoCuenta(resultSet.getString("tipoCuenta"));

                    return transaccion;
                } else {
                    return null;
                }
            }
        }
    }

    // Otros métodos según las operaciones necesarias (actualizar, eliminar, obtener todos, etc.)
}

   
