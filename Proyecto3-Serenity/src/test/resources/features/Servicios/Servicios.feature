Feature: un usuario accede a la pagina Servicios correctamente

Scenario: comprobar que la pagina servicios se carga correctamente

  Given un usuario se encuentra en la web

  When el usuario accede sección Servicios

  Then se carga la página Servicios y se muestran los contenidos correctamente
  
Scenario: los servicios se muestran en un elemento acordeón

  Given el usuario accede a la página Servicios

  When el contenido de la página se carga

  Then se muestra al menos un elemento de tipo acordeón