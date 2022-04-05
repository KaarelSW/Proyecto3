Feature: Como usuario quiero poder acceder a la página Home de la web para poder conocer la empresa

Scenario: la página Home presenta sección de clientes
  Given un usuario se encuentra en la sección Home
  When el usuario navega por la página
  Then usuario visualiza sección de clientes
  
Scenario: la sección Home presenta descripción y valores de la empresa
  Given un usuario se encuentra en la sección Home
  When el usuario navega por la página 
  Then usuario visualiza descripción y valores de la empresa


Scenario: comprobar que los enlaces del navbar en la sección Home, funcionan.
  Given un usuario se encuentra en la sección Home
  When el usuario clica en todos los links del navbar
  Then todos los links funcionan y redirigen correctamente
