package com.ejemplos.testing.serenity.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;
import com.ejemplos.testing.serenity.tasks.search.LookForInformation;
import com.ejemplos.testing.serenity.tasks.search.WikipediaArticle;


public class HomeStepDefinitions{

	//Al indica el actor, parece realmente el punto de vista del usuario
    @Given("{actor} un usuario se encuentra en la web")
    public void he_is_researching_things_on_the_internet(Actor actor) {
        actor.wasAbleTo(
        		NavigateTo.theLucaHomePage()
        );
		//En el fondo realmente estamos haciendo
		//  actor.attemptsTo(Open.url(targetUrl:"https://wikipedia.org"));
    }

    @When("{actor} accede sección Servicios")
    public void he_looks_up(Actor actor, String term) {
		//wasAbleTo y attemptsTo son muy parecidos. 
		//Realmente es lo mismo, pero cada uno en su sitio  ;-)
        actor.attemptsTo(
                LookForInformation.about(term)
        );
        //En el fondo realmente estamos haciendo
        //  Enter.theValue("van Gogh").into(<elemento_web>),
        //  Click.on(Button)
    }

    @Then("{actor} accede sección Servicios ")
    public void he_should_see_information_about(Actor actor, String term) {
        actor.attemptsTo(
                Ensure.that(WikipediaArticle.HEADING).hasText(term)
        );
        //Si no nos hubieran pasado el actor, podriamos recuperarlo
        //OnStage.theActorInTheSpotlight().attemptsTo(tasks);
    }
}
