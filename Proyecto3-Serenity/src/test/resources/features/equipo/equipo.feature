@REQ_P3Q-12
Feature: Como usuario quiero poder acceder a la página Equipo de la web para poder visualizar los miembros del equipo de desarrollo

@TEST_P3Q-118 @TESTSET_P3Q-14 @Web
Scenario: los enlaces del footer son siempre visibles en la página Equipo y funcionan correctamente.
	
	Given el usuario accede a la página Equipo
	When el contenido de la página se carga
	Then hay un elemento footer
	And hay un enlace correcto a la página Home
	And hay un enlace correcto a la página Contacto
	And hay un enlace correcto a la página Servicios
  