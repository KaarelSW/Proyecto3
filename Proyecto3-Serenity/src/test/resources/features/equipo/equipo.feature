@REQ_P3Q-12
Feature: Como usuario quiero poder acceder a la página Equipo de la web para poder visualizar los miembros del equipo de desarrollo

@TEST_P3Q-129 @TESTSET_P3Q-14 @Web
Scenario: un usuario con discapacidad visual leve es capaz de ver los contenidos de la página Equipo 
  Given un usuario accede a la sección Equipo
  When ese usuario navega por la página Equipo
  Then es capaz de leer cualquier texto de la página Equipo
  
@TEST_P3Q-128 @TESTSET_P3Q-14 @Web
Scenario: un usuario con daltonismo es capaz de navegar sin problema por la página Equipo
  Given un usuario accede a la sección Equipo
  When ese usuario navega por la página Equipo
	Then no tiene ningún impedimento respecto a los contrastes de texto-fondo en Equipo
	
@TEST_P3Q-98 @TESTSET_P3Q-14 @Web
Scenario: La información sobre los objetivos principales de la empresa se muestra
  Given un usuario accede a la sección Equipo
  When ese usuario navega por la página Equipo
  Then se muestra la sección con la información de los principales objetivos de la empresa

@TEST_P3Q-113 @TESTSET_P3Q-14 @Web  
 Scenario: los enlaces del footer son siempre visibles en la página Equipo y funcionan correctamente.
  Given un usuario accede a la sección Equipo
  When ese usuario navega por la página Equipo
  Then hay un elemento footer en Equipo
	And los enlaces del footer de equipo funcionan correctamente
	
@TEST_P3Q-121 @TESTSET_P3Q-14 @Web	
Scenario: un usuario con ceguera es capaz de obtener todos los textos "alt" de los elementos "img" de la página Equipo
  Given un usuario accede a la sección Equipo
  When ese usuario navega por la página Equipo
  Then es capaz obtener todos textos alt de los elementos img de la página equipo

@TEST_P3Q-93 @TESTSET_P3Q-14 @Web  
Scenario: La información sobre el equipo de desarrolladores se muestra
  Given un usuario accede a la sección Equipo
  When ese usuario navega por la página Equipo
  Then se muestra la sección con la información del Equipo
  
@TEST_P3Q-118 @TESTSET_P3Q-14 @Web  
Scenario: los enlaces de la barra de navegación son siempre visibles en la página Equipo y funcionan correctamente
  Given un usuario accede a la sección Equipo
  When ese usuario navega por la página Equipo
  Then visualiza una barra de navegación en la página Equipo
	And hay un enlace correcto a la página Privacidad de Equipo
	And hay un enlace correcto a la página Terminos de Equipo	
	And hay un enlace correcto a la página Contacto de Equipo