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
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjecutivoRepository {
    private final Connection connection = null; 

   public Ejecutivo obtenerEjecutivoPorRut(String rut) throws SQLException {
    String query = "SELECT * FROM ejecutivo WHERE rutEjecutivo = ?";
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, rut);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                Ejecutivo ejecutivo = new Ejecutivo();
                ejecutivo.setRutEjecutivo(resultSet.getString("rutEjecutivo"));
                ejecutivo.setNombre(resultSet.getString("nombre"));
                ejecutivo.setDepartamento(resultSet.getString("departamento"));
                ejecutivo.setContrasena(resultSet.getString("contrasena")); // Obtener la contraseña de la base de datos

                return ejecutivo;
            } else {
                return null; // No se encontró el ejecutivo
            }
        }
    }
}}