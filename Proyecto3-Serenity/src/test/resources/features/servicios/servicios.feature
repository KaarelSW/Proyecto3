Feature: un usuario accede a la pagina Servicios correctamente

Scenario: comprobar que la pagina servicios se carga correctamente

	Given un usuario se encuentra en la web
	When el usuario accede sección Servicios
	Then se carga la página Servicios y se muestran los contenidos correctamente
  
Scenario: los enlaces del footer son siempre visibles en la página Servicios y funcionan correctamente.
		
	Given el usuario accede a la página Servicios
	When el contenido de la página se carga
	Then hay un elemento footer	
	And hay un enlace correcto a la página Home
	And hay un enlace correcto a la página Contacto		
	And hay un enlace correcto a la página Equipo
	
Feature: Como usuario quiero poder acceder a la página Servicios de la web para poder visualizar los servicios y productos de la empresa

	Scenario: la sección redes sociales funciona correctamente
		Given el usuario accede a la página Servicios
		When usuario contenido de la página se carga
		Then usuario se muestra una sección de redes sociales
		And usuario sus enlaces redirigen correctamente a las redes