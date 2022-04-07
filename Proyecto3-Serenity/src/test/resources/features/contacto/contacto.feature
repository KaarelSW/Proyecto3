@REQ_P3Q-11
Feature: Como usuario quiero poder acceder al formulario en la página Contacto para enviar una solicitud a la empresa

Scenario: Un usuario en la página de contacto visualiza los términos de uso
  Given un usuario en la página Contacto
  When clickea en los términos de uso
  Then te redirige a la correspondiente página
 

@TEST_P3Q-103 @TESTSET_P3Q-36 @Web
Scenario: Un usuario entra a la página Contacto
  Given un usuario en la página Home
  When ese usuario hace click en ir a Contacto
  Then la página Contacto carga correctamente
  

