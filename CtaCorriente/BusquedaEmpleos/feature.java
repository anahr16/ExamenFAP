Feature: B�squeda de empleos en www.iplacex.cl

Scenario: B�squeda de empleos por palabra clave y regi�n
    Given Estoy en la p�gina principal de iplacex
    When selecciono la pesta�a "ALUMNOS" y hago clic en "Empleos"
    And selecciono la regi�n deseada
    And escribo la palabra clave "Ingeniero en Inform�tica"
    Then deber�a ver una lista de empleos relacionados

