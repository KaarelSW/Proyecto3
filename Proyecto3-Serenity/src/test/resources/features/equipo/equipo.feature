@REQ_P3Q-12
Feature: Como usuario quiero poder acceder a la página Equipo de la web para poder visualizar los miembros del equipo de desarrollo

@TEST_P3Q-129 @TESTSET_P3Q-14 @Web
Scenario: un usuario con discapacidad visual leve es capaz de ver los contenidos de la página Equipo 
  Given un usuario accede a la sección Equipo
  When ese usuario navega por la página Equipo
  Then es capaz de leer cualquier texto de la página Equipo