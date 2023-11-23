/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platinum.ctacorriente.Servlet;

import com.platinum.ctacorriente.model.Persona;
import com.platinum.ctacorriente.repository.PersonaRepository;
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
@WebServlet("/registroPersona")
public class RegistroPersonaServlet extends HttpServlet {
    private PersonaRepository personaRepository; // Debes inicializar esto con una instancia adecuada

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros del formulario
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String nombreMascota = request.getParameter("nombreMascota");

        // Crear una nueva persona
        Persona nuevaPersona = new Persona();
        nuevaPersona.setRut(rut);
        nuevaPersona.setNombre(nombre);
        nuevaPersona.setApellido(apellido);
        nuevaPersona.setDireccion(direccion);
        nuevaPersona.setCorreo(correo);
        nuevaPersona.setTelefono(telefono);
        nuevaPersona.setNombreMascota(nombreMascota);

        // Agregar la persona a la base de datos
        try {
            personaRepository.agregarPersona(nuevaPersona);
        }catch (SQLException ex) {
            Logger.getLogger(RegistroPersonaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Manejar errores de la base de datos
        response.sendRedirect("registro_persona_exitoso.jsp");
    }
}
