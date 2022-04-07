Feature: Como usuario quiero poder acceder al formulario en la página Contacto para enviar una solicitud a la empresa

Scenario: Un usuario en la página de contacto visualiza los términos de uso
  Given un usuario en la página Contacto
  When clickea en los términos de uso
  Then te redirige a la correspondiente página