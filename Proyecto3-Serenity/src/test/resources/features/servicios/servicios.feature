Feature: Como usuario quiero poder acceder a la página Servicios de la web para poder visualizar los servicios y productos de la empresa

Scenario: la sección redes sociales funciona correctamente
	Given el usuario accede a la página Servicios
  When usuario contenido de la página se carga
  Then usuario se muestra una sección de redes sociales
  And usuario sus enlaces redirigen correctamente a las redes
  
  
 Scenario: un usuario con ceguera es capaz de interpretar los contenidos de Servicios
  Given un usuario con ceguera accede a la web
  When ese usuario navega por la página Servicios
  Then es capaz obtener todos textos "alt" de los elementos "img" de la página