package com.ejemplos.testing.serenity.stepdefinitions;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.waits.Wait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ejemplos.testing.serenity.tasks.footer.Footer;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;



public class EquipoStepDefinitions{	
	
	WebDriver driver = Serenity.getDriver();

	
	@Given("un {actor} accede a la página Equipo")
    public void is_in_home_page(Actor actor) {
        actor.wasAbleTo(
        		NavigateTo.theLucaEquipoPage()
        );
    }
	
	@When("ese {actor} navega por la página Equipo")
    public void usuario_navega_por_la_pagina(Actor actor) {
        actor.attemptsTo(
        		NavigateTo.theLucaHomePage()
        );
    }
	
	 @Then("hay un elemento footer en la página Equipo")
	    public void hay_un_elemento_footer_en_la_pagina_equipo() {
	    	OnStage.theActorInTheSpotlight().attemptsTo(
	    			Ensure.that(Footer.FOOTER_ITEM).isDisplayed()
	    	);
	    }
	 
	 @And("hay un enlace correcto a la página Privacidad de Equipo")
	    public void el_enlace_a_Privacidad_Equipo_es_correcto() {
	    	OnStage.theActorInTheSpotlight().attemptsTo(
	    			JavaScriptClick.on(Footer.LINK_PRIVACIDAD),
	    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
	    			Ensure.thatTheCurrentPage().currentUrl().contains("privacidad"),
	    			NavigateTo.theLucaHomePage()
	    	);  
	    }
	 
	 @And("hay un enlace correcto a la página Terminos de Equipo")
	    public void el_enlace_a_Terminos_Equipo_es_correcto() {
	    	OnStage.theActorInTheSpotlight().attemptsTo(
	    			JavaScriptClick.on(Footer.LINK_TERMINOS),
	    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
	    			Ensure.thatTheCurrentPage().currentUrl().contains("terminos"),
	    			NavigateTo.theLucaHomePage()
	    	);  
	    }
	 
	 @And("hay un enlace correcto a la página Contacto de Equipo")
	    public void el_enlace_a_Contacto_Equipo_es_correcto() {
	    	OnStage.theActorInTheSpotlight().attemptsTo(
	    			JavaScriptClick.on(Footer.LINK_CONTACTO),
	    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
	    			Ensure.thatTheCurrentPage().currentUrl().contains("contact"),
	    			NavigateTo.theLucaHomePage()
	    	);  
	    }
}
