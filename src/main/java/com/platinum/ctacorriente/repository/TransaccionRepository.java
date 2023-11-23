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

import com.platinum.ctacorriente.model.Transaccion;

public class TransaccionRepository {

    // Configurar y manejar la conexión a la base de datos
    public TransaccionRepository(Connection connection) {
    }

    public void agregarTransaccion(Transaccion transaccion) throws SQLException {
        // Implementación similar al repositorio de Usuario
    }

    public Transaccion obtenerTransaccionPorId(int id) throws SQLException {
        // Implementación similar al repositorio de Usuario
        return null;
        // Implementación similar al repositorio de Usuario
    }

    // Otros métodos para actualizar, eliminar, obtener todos, etc.
}