package com.ejemplos.testing.serenity.tasks.navbar;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class NavBar {

	static Target RIGHT_NAVBAR_ITEM = Target.the("navbar").locatedBy(".nav-item");
	static Target HOME_BRAND_BUTTON = Target.the("link home brand").locatedBy(".navbar-brand");
	static Target HOME_BUTTON = Target.the("link home").locatedBy("//u[.='Home']//parent::a").inside(RIGHT_NAVBAR_ITEM);
	static Target SERVICIOS_BUTTON = Target.the("link servicios").locatedBy("//u[.='Servicios']//parent::a").inside(RIGHT_NAVBAR_ITEM);
	static Target EQUIPO_BUTTON = Target.the("link equipo").locatedBy("//u[.='Equipo']//parent::a").inside(RIGHT_NAVBAR_ITEM);
	static Target CONTACTO_BUTTON = Target.the("link contacto").locatedBy("//u[.='Contacto']//parent::a").inside(RIGHT_NAVBAR_ITEM);
	
	
	public static Target[] NAVBAR_LINKS = {HOME_BRAND_BUTTON, HOME_BUTTON, SERVICIOS_BUTTON, EQUIPO_BUTTON, CONTACTO_BUTTON};

}
