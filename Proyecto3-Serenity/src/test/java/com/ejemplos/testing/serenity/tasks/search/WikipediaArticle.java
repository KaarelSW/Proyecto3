package com.ejemplos.testing.serenity.tasks.search;

import net.serenitybdd.screenplay.targets.Target;

public class WikipediaArticle {
    public static final Target HEADING =  
    		Target.the("article identifier").
    		locatedBy("//h1");
}
