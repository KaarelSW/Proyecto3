@REQ_P3Q-11
Feature: Como usuario quiero poder acceder al formulario en la página Contacto para enviar una solicitud a la empresa

@TEST_P3Q-106 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Un usuario intenta enviar un formulario con 'Nombre Completo' vacío
	Given un usuario en la página Contacto
	When redacta el formulario con el campo 'Nombre Completo' vacío
	And hace click en el botón 'Submit'
	Then se muestra una alerta al respecto

@TEST_P3Q-103 @TESTSET_P3Q-36 @Web
Scenario: Un usuario entra a la página Contacto
  Given un usuario en la página Home
  When ese usuario hace click en ir a Contacto
  Then la página Contacto carga correctamente