Feature: Como usuario quiero poder acceder a la página Servicios de la web para poder visualizar los servicios y productos de la empresa

Scenario: la sección redes sociales funciona correctamente
	Given el usuario accede a la página Servicios
  When ese usuario contenido de la página se carga
  Then usuario se muestra una sección de redes sociales
  And usuario sus enlaces redirigen correctamente a las redes
  
  
 Scenario: un usuario con ceguera es capaz de interpretar los contenidos de Servicios
  Given un usuario con ceguera accede a la pagina servicios
  When ese usuario con ceguera navega por la pagina servicios
  Then es capaz de obtener todos los textos alt de los elementos img de la pagina