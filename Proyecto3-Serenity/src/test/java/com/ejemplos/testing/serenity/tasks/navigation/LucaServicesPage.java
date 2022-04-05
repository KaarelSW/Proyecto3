package com.ejemplos.testing.serenity.tasks.navigation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://lucaticenterprise.herokuapp.com/service")
public class LucaServicesPage extends PageObject {
	public static final Target ACCORDION = Target.the("acordeon").locatedBy(".accordion-item");
}
