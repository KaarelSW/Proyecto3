Feature: Services page

Scenario: la sección redes sociales funciona correctamente
	Given el usuario accede a la página Servicios
  When usuario contenido de la página se carga
  Then usuario se muestra una sección de redes sociales
  And usuario sus enlaces redirigen correctamente a las redes