
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anahr
 */
public class StepDefinitions {

    @Given("El usuario abre el navegador")
    public void openBrowser() {
        // Configuración de Selenium para abrir el navegador
    }

    @When("El usuario ingresa al sitio web")
    public void navigateToWebsite() {
        // Configuración de Selenium para navegar al sitio web
    }

    @And("Ingresa el nombre de usuario y la contraseña")
    public void enterCredentials() {
        // Configuración de Selenium para ingresar credenciales
    }

    @Then("El usuario debería iniciar sesión correctamente")
    public void verifyLogin() {
        // Configuración de Selenium para verificar el inicio de sesión
    }
}
