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

import com.platinum.ctacorriente.model.Usuario;

public class UsuarioRepository {
    private final Connection connection; 

    public UsuarioRepository(Connection connection) {
        this.connection = connection;
    }

    public void agregarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nombreUsuario, password) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getNombreUsuario());
            preparedStatement.setString(2, usuario.getPassword());

            preparedStatement.executeUpdate();
        }
    }

    public Usuario obtenerUsuarioPorId(int id) throws SQLException {
        String query = "SELECT * FROM usuario WHERE id = ?";
        Usuario usuario = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
                    usuario.setPassword(resultSet.getString("password"));
                }
            }
        }

        return usuario;
    }

    
}