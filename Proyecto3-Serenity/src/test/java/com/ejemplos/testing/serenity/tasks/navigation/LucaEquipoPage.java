package com.ejemplos.testing.serenity.tasks.navigation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://lucaticenterprise.herokuapp.com/equipo.html")
public class LucaEquipoPage extends PageObject {

	public static final Target OBJETIVOS =  
    		Target.the("texto objetivos").
    		locatedBy("/html/body/main/header/div/div/div/div/p");

	public static final Target EQUIPO =  
    		Target.the("equipo Lucatic Enterprise").
    		locatedBy("/html/body/main/header/div/div/div/div/p");
}
