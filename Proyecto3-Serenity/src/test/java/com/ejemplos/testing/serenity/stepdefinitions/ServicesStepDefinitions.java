package com.ejemplos.testing.serenity.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;

import org.openqa.selenium.WebDriver;

import com.ejemplos.testing.serenity.tasks.navigation.LucaServicesPage;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;

/*
 * The sample code uses the Screenplay pattern. 
 * The Screenplay pattern describes tests in terms of actors and the tasks they perform. 
 * Tasks are represented as objects performed by an actor, rather than methods. 
 * This makes them more flexible and composable, at the cost of being a bit more wordy. 
 */
//Añadimos lo de nuestro .feature

public class ServicesStepDefinitions{	

    @Given("el {actor} accede a la página Servicios")
    public void usuario_en_la_sección_Home(Actor actor) {
    	actor.wasAbleTo(
        		NavigateTo.theLucaServicePage()
        );
    }

    @When("{actor} contenido de la página se carga")
    public void el_contenido_de_la_página_se_carga(Actor actor) {
    	actor.attemptsTo	(
        		Scroll.to(LucaServicesPage.REDES_SOCIALES_CARD)
        );
    }
    
    @Then("{actor} se muestra una sección de redes sociales")
    public void se_muestra_una_sección_de_redes_sociales(Actor actor) {
        actor.attemptsTo(
        		Ensure.that(LucaServicesPage.REDES_SOCIALES_CARD).isDisplayed()
        );
        actor.attemptsTo(
        		Ensure.that(LucaServicesPage.ICO_TWITTER).isDisplayed()
        );
        actor.attemptsTo(
        		Ensure.that(LucaServicesPage.ICO_FACEBOOK).isDisplayed()
        );
        actor.attemptsTo(
        		Ensure.that(LucaServicesPage.ICO_LINKEDIN).isDisplayed()
        );
        actor.attemptsTo(
        		Ensure.that(LucaServicesPage.ICO_YOUTUBE).isDisplayed()
        );
    }
    
    WebDriver driver = Serenity.getDriver();
    String url;
    @And("{actor} sus enlaces redirigen correctamente a las redes")
    public void sus_enlaces_redirigen_correctamente_a_las_redes(Actor actor) {
    	// Comprobar que el enlace a Twitter funciona
        actor.attemptsTo(
        		JavaScriptClick.on(LucaServicesPage.ICO_TWITTER)
        );
        url = driver.getCurrentUrl();
        NavigateTo.theLucaServicePage();
        actor.attemptsTo(
        		Ensure.that(url).contains("twitter")
        );
        
    	// Comprobar que el enlace a Facebook funciona
        actor.attemptsTo(
        		JavaScriptClick.on(LucaServicesPage.ICO_FACEBOOK)
        );
        url = driver.getCurrentUrl();
        NavigateTo.theLucaServicePage();
        actor.attemptsTo(
        		Ensure.that(url).contains("facebook")
        );
     // Comprobar que el enlace a LinkedIn funciona
        actor.attemptsTo(
        		JavaScriptClick.on(LucaServicesPage.ICO_LINKEDIN)
        );
        url = driver.getCurrentUrl();
        NavigateTo.theLucaServicePage();
        actor.attemptsTo(
        		Ensure.that(url).contains("linkedin")
        );
        
    	// Comprobar que el enlace a Youtube funciona
        actor.attemptsTo(
        		JavaScriptClick.on(LucaServicesPage.ICO_YOUTUBE)
        );
        url = driver.getCurrentUrl();
        NavigateTo.theLucaServicePage();
        actor.attemptsTo(
        		Ensure.that(url).contains("youtube")
        );
    }
    
    
}
