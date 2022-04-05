package com.ejemplos.testing.serenity.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;
import com.ejemplos.testing.serenity.tasks.search.LookForInformation;
import com.ejemplos.testing.serenity.tasks.search.WikipediaArticle;

import org.openqa.selenium.WebDriver;

import com.ejemplos.testing.serenity.tasks.navbar.NavBar;

public class HomeStepDefinitions{

    @Given("un {actor} se encuentra en la sección Home")
    public void is_in_home_page(Actor actor) {
        actor.wasAbleTo(
        		NavigateTo.theLucaHomePage()
        );

    }
    
    WebDriver driver = Serenity.getDriver();
    String[] urls = new String[5];
    
    @When("el {actor} clica en todos los links del navbar")
    public void clica_en_links_navbar(Actor actor) {

        for (int i = 0; i < NavBar.NAVBAR_LINKS.length; i++) {

			actor.attemptsTo(
					JavaScriptClick.on(NavBar.NAVBAR_LINKS[i])
			);
			urls[i] = driver.getCurrentUrl();
			actor.attemptsTo(
	        		NavigateTo.theLucaHomePage()
	        );
		}
        
    }

    @Then("todos los links funcionan y redirigen correctamente")
    public void links_navbar_home_son_correctos() {
        
    	OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(urls[0]).contains("home")
        );
    	OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(urls[1]).contains("home")
        );
    	OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(urls[2]).contains("service")
        );
    	OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(urls[3]).contains("equipo")
        );
    	OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(urls[4]).contains("contact")
        );
    }
}
