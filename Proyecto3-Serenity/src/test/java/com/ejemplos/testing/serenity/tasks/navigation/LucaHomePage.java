package com.ejemplos.testing.serenity.tasks.navigation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://lucaticenterprise.herokuapp.com/")
public class LucaHomePage extends PageObject {
	public static final Target CLIENTES =  
    		Target.the("texto clientes").
    		locatedBy("/html/body/main/section[2]/div/div[1]/div/div/h2");
	

	public static final Target DESCRIPCION =  
    		Target.the("descripcion empresa").
    		locatedBy("//h1");
}
