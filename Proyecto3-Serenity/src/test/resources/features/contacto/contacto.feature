@REQ_P3Q-11
Feature: Como usuario quiero poder acceder al formulario en la página Contacto para enviar una solicitud a la empresa

@TEST_P3Q-106 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Un usuario intenta enviar un formulario con 'Nombre Completo' vacío
	Given un usuario en la página Contacto
	When redacta el formulario con el campo 'Nombre Completo' vacío
	And hace click en el botón 'Submit'
	Then se muestra una alerta al respecto
		
@TEST_P3Q-88 @TESTSET_P3Q-36		
Scenario: Un usuario en la página de contacto visualiza los términos de uso
  Given un usuario en la página Contacto
  When clickea en los términos de uso
  Then te redirige a la correspondiente página
 
@TEST_P3Q-122 @TESTSET_P3Q-36 @Accesibilidad @Web
Scenario: un usuario con daltonismo es capaz de navegar sin problema por la página Contacto
	Given un usuario en la página Contacto
	When ese usuario navega por la página Contacto
	Then no tiene ningún impedimento respecto al contraste de texto-fondo

@TEST_P3Q-60 @TESTSET_P3Q-36 @Accesibilidad @Web	
Scenario: un usuario con discapacidad visual leve es capaz de ver el contenido de Contacto
  Given un usuario en la página Contacto
  When ese usuario navega por la página Contacto
  Then puede de leer toda la sección correctamente
		

@TEST_P3Q-103 @TESTSET_P3Q-36 @Web
Scenario: Un usuario entra a la página Contacto
  Given un usuario en la página Home
  When ese usuario hace click en ir a Contacto
  Then la página Contacto carga correctamente
  
  

  
