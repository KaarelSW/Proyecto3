package com.ejemplos.testing.serenity.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    //Normalmente se utiliza tal cual esta aqui escrito
    //Realmente lo que indicamos es que Serenity coja el control de la herramienta, driver, etc.
    //    que deje por debajo Selenium, y que Serenity esté por encima
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
