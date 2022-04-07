package com.ejemplos.testing.serenity.tasks.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
	
    public static Performable theLucaHomePage() {
        return Task.where("{0} opens the Lucatic Enterprise home page",
                Open.browserOn().the(LucaHomePage.class));
    }
    
    public static Performable theLucaServicePage() {
        return Task.where("{0} opens the Lucatic Enterprise services page",
                Open.browserOn().the(LucaServicesPage.class));
    }
    

    public static Performable theLucaContactPage() {
        return Task.where("{0} opens the Lucatic Enterprise contact page",
                Open.browserOn().the(LucaContactPage.class));
    }
}
