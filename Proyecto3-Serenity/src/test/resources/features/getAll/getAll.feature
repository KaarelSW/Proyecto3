Feature: Como administrador quiero poder obtener un listado para ver todos los empleados de la empresa

	Scenario: Al hacer una petición se recibe un objeto JSON
	   Given un administrador	
	   When hace una petición a la API
	   Then obtiene información en formato JSON
	   
	Scenario: Se lanza una petición que devuelve un número determinado de empleados
	   Given un administrador
	   When hace una petición a la API
	   And sabe cuántos empleados existen
	   Then recibe la información de dichos empleados en formato JSON