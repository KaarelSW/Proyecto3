Feature: Home page

Scenario: la página Home presenta sección de clientes
  Given usuario en la sección Home
  When usuario navega por la página
  Then usuario visualiza sección de clientes
  
 Scenario: la sección Home presenta descripción y valores de la empresa
  Given usuario en la sección Home
  When usuario navega por la página 
  Then usuario visualiza descripción y valores de la empresa
