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
import java.sql.SQLException;

import com.platinum.ctacorriente.model.Persona;

public class PersonaRepository {

    // Configurar y manejar la conexión a la base de datos
    public PersonaRepository(Connection connection) {
    }

    public void agregarPersona(Persona persona) throws SQLException {
        // Implementación similar al repositorio de Usuario
    }

    public Persona obtenerPersonaPorRut(String rut) throws SQLException {
        // Implementación similar al repositorio de Usuario
        return null;
        // Implementación similar al repositorio de Usuario
    }

    
}