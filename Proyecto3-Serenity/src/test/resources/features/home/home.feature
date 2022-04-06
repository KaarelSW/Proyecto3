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

	Scenario: validar que usuario con ceguera puede ver los contenidos de Home
		Given un usuario con ceguera accede a la página Home
		When ese usuario con ceguera navega por la página
		Then es capaz de obtener todos los textos alt de los elementos img de la pagina
		
	Scenario: un usuario con discapacidad visual leve es capaz de ver los contenidos de Home
		Given un usuario con discapacidad visual leve accede a la página Home
		When ese usuario con discapacidad visual leve navega por la página
		Then es capaz de leer cualquier texto de la página Home
