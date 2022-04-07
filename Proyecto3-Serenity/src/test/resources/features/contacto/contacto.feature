@REQ_P3Q-11
Feature: Como usuario quiero poder acceder al formulario en la página Contacto para enviar una solicitud a la empresa

@TEST_P3Q-106 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Un usuario intenta enviar un formulario con 'Nombre Completo' vacío
	Given un usuario en la página Contacto
	When redacta el formulario con el campo 'Nombre Completo' vacío
	And hace click en el botón 'Submit'
	Then se muestra una alerta sobre nombre vacío
  
@TEST_P3Q-107 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Un usuario intenta enviar un formulario con 'Email' vacío
	Given un usuario en la página Contacto
	When redacta el formulario con el campo 'Email' vacío
	And hace click en el botón 'Submit'
	Then se muestra una alerta sobre email vacío
	
@TEST_P3Q-108 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Un usuario intenta enviar un formulario con 'Teléfono' vacío
	Given un usuario en la página Contacto
	When redacta el formulario con el campo 'Teléfono' vacío
	And hace click en el botón 'Submit'
	Then se muestra una alerta sobre teléfono vacío
	
@TEST_P3Q-109 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Un usuario intenta enviar un formulario con 'Mensaje' vacío
	Given un usuario en la página Contacto
	When redacta el formulario con el campo 'Mensaje' vacío
	And hace click en el botón 'Submit'
	Then se muestra una alerta sobre mensaje vacío
	
@TEST_P3Q-68 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Un usuario trata de enviar el formulario sin aceptar las políticas de privacidad
	Given un usuario en la página Contacto		
	When rellena el formulario sin aceptar las políticas de privacidad		
	Then aparece una advertencia sobre aceptar las políticas
	
@TEST_P3Q-67 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Un usuario trata de enviar el formulario sin seleccionar que es mayor de edad		
	Given un usuario en la página Contacto
	When rellena el formulario sin seleccionar que es mayor de edad		
	Then aparece una advertencia sobre la edad
	
@TEST_P3Q-40 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Se trata de enviar un formulario con menos de 3 caracteres en el campo 'Nombre Completo'
	Given un usuario en la página Contacto
	When rellena el formulario poniendo menos de 3 caracteres en el campo 'Nombre Completo'
	Then se muestra un aviso sobre la longitud del nombre
	
@TEST_P3Q-44 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Se trata de enviar un formulario con menos de 3 caracteres en el campo 'Email'
	Given un usuario en la página Contacto
	When rellena el formulario poniendo menos de 3 caracteres en el campo 'Email'
	Then se muestra un aviso sobre la longitud del email
	
@TEST_P3Q-45 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Se trata de enviar un formulario con menos de 3 caracteres en el campo 'Teléfono'
	Given un usuario en la página Contacto
	When rellena el formulario poniendo menos de 3 caracteres en el campo 'Teléfono' 
	Then se muestra un aviso sobre la longitud del teléfono
	
@TEST_P3Q-46 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Se trata de enviar un formulario con menos de 3 caracteres en el campo 'Mensaje'
	Given un usuario en la página Contacto
	When rellena el formulario poniendo menos de 3 caracteres en el campo 'Mensaje'
	Then se muestra un aviso sobre la corta longitud del mensaje

@TEST_P3Q-49 @TESTSET_P3Q-36 @Cucumber @Web
Scenario: Se trata de enviar un formulario con más de 300 caracteres en el campo "Mensaje"
	Given un usuario en la página Contacto
  When rellena el formulario poniendo más de 300 caracteres en el campo 'Mensaje'
	Then se muestra un aviso sobre la excesiva longitud del mensaje
		
@TEST_P3Q-88 @TESTSET_P3Q-36		
Scenario: Un usuario en la página de contacto visualiza los términos de uso
  Given un usuario en la página Contacto
  When clickea en los términos de uso
  Then te redirige a la correspondiente página
 
@TEST_P3Q-122 @TESTSET_P3Q-36 @Accesibilidad @Web
Scenario: Un usuario con daltonismo es capaz de navegar sin problema por la página Contacto
	Given un usuario en la página Contacto
	When ese usuario navega por la página Contacto
	Then no tiene ningún impedimento respecto al contraste de texto-fondo

@TEST_P3Q-60 @TESTSET_P3Q-36 @Accesibilidad @Web	
Scenario: Un usuario con discapacidad visual leve es capaz de ver el contenido de Contacto
  Given un usuario en la página Contacto
  When ese usuario navega por la página Contacto
  Then puede de leer toda la sección correctamente		

@TEST_P3Q-103 @TESTSET_P3Q-36 @Web
Scenario: Un usuario entra a la página Contacto
  Given un usuario en la página Home
  When ese usuario hace click en ir a Contacto
  Then la página Contacto carga correctamente

