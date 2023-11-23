/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platinum.ctacorriente.Servlet;

import com.platinum.ctacorriente.model.CtaCorriente;
import com.platinum.ctacorriente.repository.CtaCorrienteRepository;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anahr
 */
@WebServlet("/registroCtaCorriente")
public class RegistroCtaCorrienteServlet extends HttpServlet {
    private CtaCorrienteRepository ctaCorrienteRepository; // Debes inicializar esto con una instancia adecuada

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros del formulario
        String rutCliente = request.getParameter("rutCliente");
        BigDecimal monto = new BigDecimal(request.getParameter("monto"));
        String ejecutivo = request.getParameter("ejecutivo");

        // Crear una nueva cuenta corriente
        CtaCorriente nuevaCtaCorriente = new CtaCorriente();
        nuevaCtaCorriente.setRutCliente(rutCliente);
        nuevaCtaCorriente.setMonto(monto);
        nuevaCtaCorriente.setEjecutivo(ejecutivo);

        // Agregar la cuenta corriente a la base de datos
        try {
            ctaCorrienteRepository.agregarCtaCorriente(nuevaCtaCorriente);
            response.sendRedirect("registro_cta_corriente_exitoso.jsp");
        } catch (SQLException e) {
            // Manejar errores de la base de datos
            e.printStackTrace();
            response.sendRedirect("registro_cta_corriente_fallido.jsp");
        }
    }
}