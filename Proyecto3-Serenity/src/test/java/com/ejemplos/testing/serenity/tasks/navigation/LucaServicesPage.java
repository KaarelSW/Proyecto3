package com.ejemplos.testing.serenity.tasks.navigation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://lucaticenterprise.herokuapp.com/service")
public class LucaServicesPage extends PageObject {
	
	public static final Target REDES_SOCIALES_CARD = Target.the("tarjeta redes sociales").locatedBy(".card-body");
	
	public static final Target ICO_TWITTER = 
			Target.the("icono LINKEDIN").locatedBy(".card-body a:nth-child(4)");
	
	public static final Target ICO_FACEBOOK = 
			Target.the("icono LINKEDIN").locatedBy(".card-body a:nth-child(5)");
	
	public static final Target ICO_LINKEDIN = 
			Target.the("icono LINKEDIN").locatedBy(".card-body a:nth-child(6)");
	
	public static final Target ICO_YOUTUBE = 
			Target.the("icono LINKEDIN").locatedBy(".card-body a:nth-child(7)");
}
