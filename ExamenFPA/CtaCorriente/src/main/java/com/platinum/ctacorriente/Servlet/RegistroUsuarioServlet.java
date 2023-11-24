/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platinum.ctacorriente.Servlet;

/**
 *
 * @author anahr
 */
import com.platinum.ctacorriente.model.Usuario;
import com.platinum.ctacorriente.repository.UsuarioRepository;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
    private UsuarioRepository usuarioRepository; 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener parámetros del formulario
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");

        // Crear un nuevo usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreUsuario(nombreUsuario);
        nuevoUsuario.setPassword(password);

        // Agregar el usuario a la base de datos
        try {
            usuarioRepository.agregarUsuario(nuevoUsuario);
            response.sendRedirect("registro_usuario_exitoso.jsp");
        } catch (SQLException e) {
            // Manejar errores de la base de datos
            e.printStackTrace();
            response.sendRedirect("registro_usuario_fallido.jsp");
        }
    }
}
