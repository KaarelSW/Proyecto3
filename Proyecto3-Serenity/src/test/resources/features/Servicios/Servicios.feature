Feature: Como usuario quiero poder acceder a la página Servicios de la web para poder visualizar los servicios y productos de la empresa

Scenario: comprobar que la pagina servicios se carga correctamente

  Given un usuario se encuentra en la web

  When ese usuario accede sección Servicios

  Then se carga la página Servicios y se muestran los contenidos correctamente
  
Scenario: los servicios se muestran en un elemento acordeón

  Given un usuario accede a la página Servicios

  When el contenido de la página se carga

  Then se muestra al menos un elemento de tipo acordeón