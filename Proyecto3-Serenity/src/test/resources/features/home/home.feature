Feature: Como usuario quiero poder acceder a la página Home de la web para poder conocer la empresa

	Scenario: la página Home presenta sección de clientes
	  Given un usuario accede a la página Home
	  When ese usuario navega por la página
	  Then usuario visualiza sección de clientes
	  
	Scenario: la sección Home presenta descripción y valores de la empresa
	  Given un usuario accede a la página Home
	  When ese usuario navega por la página 
	  Then usuario visualiza descripción y valores de la empresa
	
	Scenario: comprobar que los enlaces del navbar en la sección Home funcionan.
		Given un usuario accede a la página Home
		When ese usuario clica en todos los links del navbar
		Then todos los links funcionan y redirigen correctamente


Scenario: comprobar que los enlaces del navbar en la sección Home, funcionan.
  Given un usuario se encuentra en la sección Home
  When ese usuario clica en todos los links del navbar
  Then todos los links funcionan y redirigen correctamente

Scenario: validar que usuario con discapacidad visual puede ver los contenidos de Home
  Given un usuario con discapacidad visual en la sección Home
  When ese usuario con discapacidad visual navega por la sección Home
  Then puede acceder a los atributos alt de las imágenes
  
  
Scenario: los enlaces del footer son siempre visibles en la página Home y funcionan correctamente.	
		Given un usuario se encuentra en la seccion Home
		When ese usuario navega por la página
		Then hay un elemento footer	
		And hay un enlace correcto a la página Privacidad
		And hay un enlace correcto a la página Terminos
		And hay un enlace correcto a la página Contacto
