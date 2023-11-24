/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platinum.ctacorriente.Servlet;

import com.platinum.ctacorriente.model.Ejecutivo;
import com.platinum.ctacorriente.repository.EjecutivoRepository;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anahr
 */
@WebServlet("/loginEjecutivo")
public class LoginServlet extends HttpServlet {
    private EjecutivoRepository ejecutivoRepository; 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros del formulario
        String rutEjecutivo = request.getParameter("rutEjecutivo");
        String contrasena = request.getParameter("contrasena");

        // Obtener el ejecutivo por el rut
        Ejecutivo ejecutivo = null;
        try {
            ejecutivo = ejecutivoRepository.obtenerEjecutivoPorRut(rutEjecutivo);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Verificar la contraseña
        if (ejecutivo != null && ejecutivo.getContrasena() != null && ejecutivo.getContrasena().equals(contrasena)) {
            // Inicio de sesión exitoso
            response.sendRedirect("inicio_sesion_exitoso.jsp");
        } else {
            // Credenciales incorrectas
            response.sendRedirect("inicio_sesion_fallido.jsp");
        }
    }
}
