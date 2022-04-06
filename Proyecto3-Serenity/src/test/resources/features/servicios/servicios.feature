Feature: un usuario accede a la pagina Servicios correctamente

	Scenario: comprobar que la pagina servicios se carga correctamente
		Given un usuario se encuentra en la web
		When ese usuario accede a la sección Servicios
		Then se carga la página Servicios y se muestran los contenidos correctamente
	  
	Scenario: los enlaces del footer son siempre visibles en la página Servicios y funcionan correctamente.	
		Given un usuario accede a la página Servicios
		When ese usuario navega por la página
		Then hay un elemento footer
		And hay un enlace correcto a la página Contacto
		And hay un enlace correcto a la página Privacidad
		And hay un enlace correcto a la página Terminos
	
	Scenario: la sección redes sociales funciona correctamente
		Given un usuario accede a la página Servicios
		When ese usuario navega por la página
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
		
	Scenario: los servicios se muestran en un elemento acordeón
		Given un usuario accede a la página Servicios
	  	When ese usuario navega por la página
	  	Then se muestra al menos un elemento de tipo acordeón
  
	Scenario: un usuario con ceguera es capaz de interpretar los contenidos de Servicios
		Given un usuario con ceguera accede a la pagina servicios
		When ese usuario con ceguera navega por la pagina servicios
		Then es capaz de obtener todos los textos alt de los elementos img de la pagina
