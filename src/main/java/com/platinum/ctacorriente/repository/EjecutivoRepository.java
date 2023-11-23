/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platinum.ctacorriente.repository;

/**
 *
 * @author anahr
 */
import com.platinum.ctacorriente.model.Ejecutivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjecutivoRepository {
    private final Connection connection; // Configurar y manejar la conexión a la base de datos

    public EjecutivoRepository(Connection connection) {
        this.connection = connection;
    }

    public void agregarEjecutivo(Ejecutivo ejecutivo) throws SQLException {
        String query = "INSERT INTO ejecutivo (rutEjecutivo, nombre, departamento) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, ejecutivo.getRutEjecutivo());
            preparedStatement.setString(2, ejecutivo.getNombre());
            preparedStatement.setString(3, ejecutivo.getDepartamento());

            preparedStatement.executeUpdate();
        }
    }

    // Puedes añadir otros métodos según las operaciones que necesites para la entidad Ejecutivo
}
