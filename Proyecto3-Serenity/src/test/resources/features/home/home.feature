@REQ_P3Q-2
Feature: Como usuario quiero poder acceder a la página Home de la web para poder conocer la empresa
	@TEST_P3Q-119 @TESTSET_P3Q-31 @Accesibilidad @UI/UX @Web
	Scenario: la página Home presenta sección de clientes
	  Given un usuario accede a la página Home
	  When ese usuario navega por la página
	  Then usuario visualiza sección de clientes
	
	@TEST_P3Q-112 @TESTSET_P3Q-31 @UI/UX @Web
	Scenario: Validar que la sección Home presenta una descripción de la empresa y sus valores
	  Given un usuario accede a la página Home
	  When ese usuario navega por la página
	  Then usuario visualiza descripción y valores de la empresa
	
	@TEST_P3Q-97 @TESTSET_P3Q-31 @Accesibilidad @UI/UX @Web
	Scenario: comprobar que los enlaces del navbar en la sección Home funcionan.
		Given un usuario accede a la página Home
		When ese usuario clica en todos los links del navbar
		Then todos los links funcionan y redirigen correctamente
	
	@TEST_P3Q-104 @TESTSET_P3Q-31 @Accesibilidad @UI/UX @Web
	Scenario: validar que usuario con ceguera puede ver los contenidos de Home
		Given un usuario con ceguera accede a la página Home
		When ese usuario con ceguera navega por la página
		Then es capaz de obtener todos los textos alt de los elementos img de la pagina
		
	@TEST_P3Q-76 @TESTSET_P3Q-31 @UI/UX @Web
	Scenario: un usuario con discapacidad visual leve es capaz de ver los contenidos de Home
		Given un usuario con discapacidad visual leve accede a la página Home
		When ese usuario con discapacidad visual leve navega por la página
		Then es capaz de leer cualquier texto de la página Home
		
	@TEST_P3Q-125 @TESTSET_P3Q-31 @Accesibilidad @UI/UX @Web
	Scenario: un usuario con daltonismo puede navegar por la sección Home sin problema
  	Given un usuario accede a la página Home
  	When ese usuario navega por la página
  	Then visualiza la página sin problemas de contraste
	@TEST_P3Q-90 @TESTSET_P3Q-31
	Scenario: los enlaces del footer son siempre visibles en la página Home y funcionan correctamente.
		Given un usuario accede a la página Home
		When ese usuario navega por la página
		Then hay un elemento footer en la página Home
		And hay un enlace correcto a la página Privacidad de Home
		And hay un enlace correcto a la página Terminos de Home
		And hay un enlace correcto a la página Contacto de Home