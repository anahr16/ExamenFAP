Feature: Ingreso de nombre de usuario con datos almacenados en BD

Scenario: Usuario válido inicia sesión
  Given El usuario está en la página de inicio de sesión
  When Ingresa el nombre de usuario válido almacenado en la base de datos
  And Ingresa la contraseña válida
  And Hace clic en el botón de inicio de sesión
  Then Debería iniciar sesión con éxito
