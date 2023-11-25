/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anahr
 */
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;
import com.platinum.ctacorriente.model.CtaCorriente;

public class CtaCorrienteTest {

    @Test
    public void testGetMonto() {
        // Crear una instancia de CtaCorriente
        CtaCorriente cuenta = new CtaCorriente(1, "123456789", new BigDecimal("1000.00"), "Ejecutivo");

        // Obtener el monto y verificar si es el esperado
        BigDecimal resultado = cuenta.getMonto();
        BigDecimal esperado = new BigDecimal("1000.00");
        assertEquals(esperado, resultado);
    }

    @Test
    public void testSetMonto() {
        // Crear una instancia de CtaCorriente
        CtaCorriente cuenta = new CtaCorriente(1, "123456789", new BigDecimal("1000.00"), "Ejecutivo");

        // Establecer un nuevo monto
        BigDecimal nuevoMonto = new BigDecimal("1500.00");
        cuenta.setMonto(nuevoMonto);

        // Verificar si el monto se ha actualizado correctamente
        BigDecimal resultado = cuenta.getMonto();
        assertEquals(nuevoMonto, resultado);
    }
}
