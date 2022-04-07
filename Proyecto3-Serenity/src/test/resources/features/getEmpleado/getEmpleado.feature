@REQ_P3Q-4
Feature: Como administrador quiero poder obtener los datos de un empleado específico para consultar la información de éste
	@TEST_P3Q-16 @TESTSET_P3Q-15 @API @Cucumber
		Scenario: Un administrador obtiene los datos de un empleado específico en formato JSON		
		  Given un administrador está logueado		
		  When pide los datos de un empleado específico con id <id>		
		  Then se obtiene un JSON con la información del empleado
			Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-19 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado se devuelven todos los datos de ese empleado		
		  Given un administrador está logueado		
		  When pide los datos de un empleado específico con id <id>
		  Then se devuelve un objeto cuyo número de propiedades coincide con las de empleado
		  Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-21 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado la propiedad nombre es una cadena de caracteres alfabéticos		   
		  Given un administrador está logueado		   
		  When pide los datos de un empleado específico con id <id>
		 	Then se devuelve un empleado cuya propiedad nombre está compuesta por caracteres alfabéticos
		 	Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-89 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado, la propiedad apellido es una cadena de caracteres alfabéticos			
			Given un administrador está logueado		
			When pide los datos de un empleado específico con id <id>
			Then se devuelve un empleado cuya propiedad apellido está compuesta por caracteres alfabéticos
			Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-91 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado, la propiedad edad es un entero			
			Given un administrador está logueado			
			When pide los datos de un empleado específico con id <id>
			Then se devuelve un empleado cuya propiedad edad es un entero
			Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-92 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado, la propiedad edad es superior a 18
			Given un administrador está logueado
			When pide los datos de un empleado específico con id <id>
			Then se devuelve un empleado cuya propiedad edad es superior a 18
			Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-100 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado, la propiedad correo tiene un formato válido			
			Given un administrador está logueado			
			When pide los datos de un empleado específico con id <id>
			Then se devuelve un empleado cuya propriedad correo tiene un formato correcto
			Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-102 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado, la propiedad teléfono tiene un formato válido			
			Given un administrador está logueado			
			When pide los datos de un empleado específico con id <id>
			Then se devuelve un empleado cuya propriedad teléfono tiene un formato correcto
			Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-110 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado la propiedad género es una cadena de caracteres alfabéticos		   
		   Given un administrador está logueado		   
		   When pide los datos de un empleado específico con id <id>
			 Then se devuelve un empleado cuya propiedad género está compuesta por caracteres alfabéticos
			 Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-114 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado la propiedad registered contiene una fecha pasada o actual		   
		  Given un administrador está logueado		   
		  When pide los datos de un empleado específico con id <id>
			Then se devuelve un empleado cuya propiedad registered contiene una fecha anterior o igual a la actual
			Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-126 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado la propiedad geolocalización es un array de dos elementos		   
		   Given un administrador está logueado		   
		   When pide los datos de un empleado específico con id <id>
			 Then se devuelve un empleado cuya propiedad geolocalización es un array de dos elementos
			 Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-134 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado la propiedad latitud es un número con decimales entre -90 y 90		   
		   Given un administrador está logueado		   
		   When pide los datos de un empleado específico con id <id>
			 Then se devuelve un empleado cuya propiedad latitud es un número con decimales entre -90 y 90
			 Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-135 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado la propiedad longitud es un número con decimales entre -180 y 180		   
		   Given un administrador está logueado		   
		   When pide los datos de un empleado específico con id <id>
			 Then se devuelve un empleado cuya propiedad longitud es un número con decimales entre -180 y 180
			 Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|
	@TEST_P3Q-136 @TESTSET_P3Q-15 @API @Cucumber
	Scenario: Al pedir los datos de un empleado la propiedad login es un array de dos elementos		   
		   Given un administrador está logueado		   
		   When pide los datos de un empleado específico con id <id>
			 Then se devuelve un empleado cuya propiedad login es un array de dos elementos
			 Examples:
		 	|id|
		 	|1|
		 	|15|
		 	|27|
		 	|33|
		 	|42|
		 	|59|
		 	|66|
		 	|72|
		 	|88|
		 	|93|