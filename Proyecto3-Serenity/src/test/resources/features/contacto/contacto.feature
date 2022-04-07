Feature: Como usuario quiero poder acceder al formulario en la página Contacto para enviar una solicitud a la empresa

Scenario: Un usuario en la página de contacto visualiza los términos de uso
  Given un usuario en la página Contacto
  When clickea en los términos de uso
  Then te redirige a la correspondiente página
  
Scenario: un usuario con daltonismo es capaz de navegar sin problema por la página Contacto
	Given un usuario en la página Contacto
	When ese usuario navega por la página Contacto
	Then no tiene ningún impedimento respecto al contraste de texto-fondo
	
Scenario: un usuario con discapacidad visual leve es capaz de ver el contenido de Contacto
  Given un usuario en la página Contacto
  When ese usuario navega por la página Contacto
  Then puede de leer toda la sección correctamente