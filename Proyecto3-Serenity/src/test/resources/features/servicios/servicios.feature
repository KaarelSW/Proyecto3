Feature: un usuario accede a la pagina Servicios correctamente

Scenario: comprobar que la pagina servicios se carga correctamente
	Given un usuario se encuentra en la web
	When el usuario accede sección Servicios
	Then se carga la página Servicios y se muestran los contenidos correctamente
  
Scenario: los enlaces del footer son siempre visibles en la página Servicios y funcionan correctamente.	
	Given el usuario accede a la página Servicios
	When el contenido de la página se carga
	Then hay un elemento footer	
	And hay un enlace correcto a la página Home
	And hay un enlace correcto a la página Contacto		
	And hay un enlace correcto a la página Equipo

Scenario: la sección redes sociales funciona correctamente
	Given un usuario accede a la página Servicios
	When usuario contenido de la página se carga
	Then usuario se muestra una sección de redes sociales
	And usuario sus enlaces redirigen correctamente a las redes
  
Scenario: un usuario con discapacidad visual leve es capaz de ver los contenidos de Servicios
	Given un usuario con discapacidad visual leve accede a la página Servicios
	When ese usuario con discapacidad visual leve navega por la página
	Then es capaz de leer cualquier texto de la página
	
Scenario: un usuario con daltonismo es capaz de navegar sin problema por la página Servicios
	Given un usuario con daltonismo accede a la página Servicios
	When ese usuario con daltonismo navega por la página
	Then no tiene ningún impedimento respecto a los contrastes de texto-fondo
