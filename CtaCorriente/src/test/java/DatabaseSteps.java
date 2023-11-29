/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anahr
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class DatabaseSteps {

    private Connection connection;

    @Before
    public void setUp() {
        // Configurar la conexión a la base de datos antes de cada escenario
        String url = "jdbc:mysql://localhost:3306/selenium";
        String user = "Alejandra";
        String password = "Cielo100";
        connection = connectToDatabase(url, user, password);
    }

    @After
    public void tearDown() throws SQLException {
        // Cerrar la conexión después de cada escenario
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Given("I have a valid database connection")
    public void iHaveAValidDatabaseConnection() {
        // No es necesario hacer nada aquí, la conexión se establece en el @Before
    }

    // Otros pasos de prueba de Cucumber que utilizan la conexión a la base de datos

    private Connection connectToDatabase(String url, String user, String password) {
        try {
            // Registrar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
