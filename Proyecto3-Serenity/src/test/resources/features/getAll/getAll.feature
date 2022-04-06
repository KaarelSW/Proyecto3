@REQ_P3Q-3
Feature: Como administrador quiero poder obtener un listado para ver todos los empleados de la empresa
	@TEST_P3Q-24 @TESTSET_P3Q-22 @API @Cucumber  
	Scenario: Al hacer una petición se recibe un objeto JSON
	   Given un administrador	
	   When hace una petición a la API
	   Then obtiene información en formato JSON
	@TEST_P3Q-27 @TESTSET_P3Q-22 @API @Cucumber   
	Scenario: Se lanza una petición que devuelve un número determinado de empleados
	   Given un administrador
	   When hace una petición a la API
	   And sabe cuántos empleados existen
	   Then recibe la información de dichos empleados en formato JSON