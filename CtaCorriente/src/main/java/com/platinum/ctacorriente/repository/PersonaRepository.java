/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platinum.ctacorriente.repository;

/**
 *
 * @author anahr
 */import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.platinum.ctacorriente.model.Persona;

public class PersonaRepository {

    private final Connection connection;

    // Configurar y manejar la conexión a la base de datos
    public PersonaRepository(Connection connection) {
        this.connection = connection;
    }

    public void agregarPersona(Persona persona) throws SQLException {
        String query = "INSERT INTO Persona (rut, nombre, apellido, direccion, correo, telefono, nombreMascota) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, persona.getRut());
            preparedStatement.setString(2, persona.getNombre());
            preparedStatement.setString(3, persona.getApellido());
            preparedStatement.setString(4, persona.getDireccion());
            preparedStatement.setString(5, persona.getCorreo());
            preparedStatement.setString(6, persona.getTelefono());
            preparedStatement.setString(7, persona.getNombreMascota());

            preparedStatement.executeUpdate();
        }
    }

    public Persona obtenerPersonaPorRut(String rut) throws SQLException {
        String query = "SELECT * FROM Persona WHERE rut = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, rut);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Persona persona = new Persona();
                    persona.setRut(resultSet.getString("rut"));
                    persona.setNombre(resultSet.getString("nombre"));
                    persona.setApellido(resultSet.getString("apellido"));
                    persona.setDireccion(resultSet.getString("direccion"));
                    persona.setCorreo(resultSet.getString("correo"));
                    persona.setTelefono(resultSet.getString("telefono"));
                    persona.setNombreMascota(resultSet.getString("nombreMascota"));

                    return persona;
                } else {
                    return null;
                }
            }
        }
    }

    // Otros métodos según las operaciones necesarias (actualizar, eliminar, obtener todos, etc.)
}