Feature: un usuario accede a la pagina Servicios correctamente

Scenario: comprobar que la pagina servicios se carga correctamente

  Given un usuario se encuentra en la web

  When el usuario accede sección Servicios

  Then se carga la página Servicios y se muestran los contenidos correctamente