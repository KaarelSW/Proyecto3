Feature: Como usuario quiero poder acceder a la página Home de la web para poder conocer la empresa

Scenario: la página Home presenta sección de clientes
  Given un usuario se encuentra en la sección Home
  When ese usuario navega por la pagina
  Then usuario visualiza sección de clientes
  
Scenario: la sección Home presenta descripción y valores de la empresa
  Given un usuario se encuentra en la sección Home
  When ese usuario navega por la pagina 
  Then usuario visualiza descripción y valores de la empresa


Scenario: comprobar que los enlaces del navbar en la sección Home, funcionan.
  Given un usuario se encuentra en la sección Home
  When ese usuario clica en todos los links del navbar
  Then todos los links funcionan y redirigen correctamente

Scenario: validar que usuario con discapacidad visual puede ver los contenidos de Home
  Given un usuario con discapacidad visual en la sección Home
  When ese usuario con discapacidad visual navega por la sección Home
  Then puede acceder a los atributos alt de las imágenes
  