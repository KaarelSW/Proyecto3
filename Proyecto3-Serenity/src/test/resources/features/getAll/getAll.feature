@REQ_P3Q-3
Feature: [HU3] Como administrador quiero poder obtener un listado para ver todos los empleados de la empresa
	#*Como* administrador
	#
	#*Quiero* poder obtener los datos de todos los empleados
	#
	#*Para* consultar la información de los mismos.

	Background:


	#Hace una petición a la API 
	#
	#*Criterio de validación:* la API devuelve los resultados en formato JSON.
	#
	#*Acciones:* Se realiza una petición a “/empleados” de la API REST.
	#
	#*Resultado esperado:* {color:#36b37e}OK{color}
	@TEST_P3Q-24 @TESTSET_P3Q-22
	#Scenario: [HU3 | TS22 | TC24] Se recibe un JSON de /empleados
		Scenario: Al hacer una petición se recibe un objeto JSON
		
		   Given un administrador
		
		   When hace una petición a la API
		
		   Then obtiene información en formato JSON

		   #Hace una petición a la API sabiendo el número determinado de empleados 
	#
	#*Criterio de validación:* la API devolverá un status 200 si encuentra un resultado independientemente de su contenido.
	#
	#*Acciones:* se realiza una petición a “/empleados” sabiendo el número de empleados que existen.
	#
	#*Resultado esperado:* {color:#36b37e}OK{color}
	@TEST_P3Q-27 @TESTSET_P3Q-22 @API @Cucumber
	#Scenario: [HU3 | TS22 | TC27] Se recibe un determinado número de elementos de /empleados
		Scenario: Se lanza una petición que devuelve un número determinado de empleados
		
		   Given un administrador
		
		   When hace una petición a la API
		
		   And sabe cuántos empleados existen
		
		   Then recibe la información de dichos empleados en formato JSON