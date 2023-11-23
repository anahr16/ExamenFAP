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

import com.platinum.ctacorriente.model.CtaCorriente;

public class CtaCorrienteRepository {
    private Connection connection; // Configurar y manejar la conexión a la base de datos

    public CtaCorrienteRepository(Connection connection) {
        this.connection = connection;
    }

    public void agregarCtaCorriente(CtaCorriente ctaCorriente) throws SQLException {
        // Implementación similar al repositorio de Usuario
    }

    public CtaCorriente obtenerCtaCorrientePorId(int idCuenta) throws SQLException {
        // Implementación similar al repositorio de Usuario
        return null;
        // Implementación similar al repositorio de Usuario
    }

    // Otros métodos para actualizar, eliminar, obtener todos, etc.
}
