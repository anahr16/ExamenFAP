/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platinum.ctacorriente.Servlet;

import com.platinum.ctacorriente.model.Transaccion;
import com.platinum.ctacorriente.repository.TransaccionRepository;
import java.io.IOException;
import java.math.BigDecimal;
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
@WebServlet("/realizarTransferencia")
public class RealizarTransferenciaServlet extends HttpServlet {
    private TransaccionRepository transaccionRepository; 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros del formulario
        String rutCliente = request.getParameter("rutCliente");
        String rutDueno = request.getParameter("rutDueno");
        int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
        BigDecimal montoTransferencia = new BigDecimal(request.getParameter("montoTransferencia"));
        String cuentaTransferencia = request.getParameter("cuentaTransferencia");
        String tipoCuenta = request.getParameter("tipoCuenta");

        // Crear una nueva transacción
        Transaccion nuevaTransaccion = new Transaccion();
        nuevaTransaccion.setRutCliente(rutCliente);
        nuevaTransaccion.setRutDueno(rutDueno);
        nuevaTransaccion.setIdCuenta(idCuenta);
        nuevaTransaccion.setMontoTransferencia(montoTransferencia);
        nuevaTransaccion.setCuentaTransferencia(cuentaTransferencia);
        nuevaTransaccion.setTipoCuenta(tipoCuenta);

        // Agregar la transacción a la base de datos
        try {
            transaccionRepository.agregarTransaccion(nuevaTransaccion);
            response.sendRedirect("transferencia_exitosa.jsp");
        } catch (SQLException e) {
            // Manejar errores de la base de datos
            e.printStackTrace();
            response.sendRedirect("transferencia_fallida.jsp");
        }
    }
}