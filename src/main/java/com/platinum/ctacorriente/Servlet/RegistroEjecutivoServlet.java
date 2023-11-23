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
@WebServlet("/registroEjecutivo")
public class RegistroEjecutivoServlet extends HttpServlet {
    private EjecutivoRepository ejecutivoRepository; // Debes inicializar esto con una instancia adecuada

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros del formulario
        String rutEjecutivo = request.getParameter("rutEjecutivo");
        String nombre = request.getParameter("nombre");
        String departamento = request.getParameter("departamento");

        // Crear un nuevo ejecutivo
        Ejecutivo nuevoEjecutivo = new Ejecutivo();
        nuevoEjecutivo.setRutEjecutivo(rutEjecutivo);
        nuevoEjecutivo.setNombre(nombre);
        nuevoEjecutivo.setDepartamento(departamento);

        try {
            // Agregar el ejecutivo a la base de datos
            ejecutivoRepository.agregarEjecutivo(nuevoEjecutivo); // Manejar errores de la base de datos
        } catch (SQLException ex) {
            Logger.getLogger(RegistroEjecutivoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("registro_ejecutivo_exitoso.jsp");
    }
}