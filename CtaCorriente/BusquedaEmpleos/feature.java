Feature: Búsqueda de empleos en www.iplacex.cl

Scenario: Búsqueda de empleos por palabra clave y región
    Given Estoy en la página principal de iplacex
    When selecciono la pestaña "ALUMNOS" y hago clic en "Empleos"
    And selecciono la región deseada
    And escribo la palabra clave "Ingeniero en Informática"
    Then debería ver una lista de empleos relacionados

