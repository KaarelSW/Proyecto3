@REQ_P3Q-4
Feature: Como administrador quiero poder obtener los datos de un empleado específico para consultar la información de éste
	@TEST_P3Q-16 @TESTSET_P3Q-15 @API @Cucumber
		Scenario: Un administrador obtiene los datos de un empleado específico en formato JSON		
		  Given un administrador está logueado		
		  When pide los datos de un empleado específico		
		  Then se obtiene un JSON con la información del empleado
	@TEST_P3Q-19 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado se devuelven todos los datos de ese empleado		
		  Given un administrador está logueado		
		  When pide los datos de un empleado específico		
		  Then se devuelve un objeto cuyo número de propiedades coincide con las de empleado
	@TEST_P3Q-21 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado la propiedad nombre es una cadena de caracteres alfabéticos		   
		  Given un administrador está logueado		   
		  When pide los datos de un empleado específico		   
		 	Then se devuelve un empleado cuya propiedad nombre está compuesta por caracteres alfabéticos
	@TEST_P3Q-89 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado, la propiedad apellido es una cadena de caracteres alfabéticos			
			Given un administrador está logueado		
			When pide los datos de un empleado específico				
			Then se devuelve un empleado cuya propiedad apellido está compuesta por caracteres alfabéticos
	@TEST_P3Q-91 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado, la propiedad edad es un entero			
			Given un administrador está logueado			
			When pide los datos de un empleado específico			
			Then se devuelve un empleado cuya propiedad edad es un entero
	@TEST_P3Q-92 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado, la propiedad edad es superior a 18
			Given un administrador está logueado
			When pide los datos de un empleado específico
			Then se devuelve un empleado cuya propiedad edad es superior a 18
	@TEST_P3Q-100 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado, la propiedad correo tiene un formato válido			
			Given un administrador está logueado			
			When pide los datos de un empleado específico	
			Then se devuelve un empleado cuya propriedad correo tiene un formato correcto
	@TEST_P3Q-114 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado la propiedad registered contiene una fecha pasada o actual		   
		  Given un administrador está logueado		   
		  When pide los datos de un empleado específico		   
			Then se devuelve un empleado cuya propiedad registered contiene una fecha anterior o igual a la actual