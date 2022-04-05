Feature: Como usuario quiero poder acceder a la página Home de la web para poder conocer la empresa

Scenario: comprobar que los enlaces del navbar en la sección Home, funcionan.
		  Given un usuario se encuentra en la sección Home
		  When el usuario clica en todos los links del navbar
		  Then todos los links funcionan y redirigen correctamente