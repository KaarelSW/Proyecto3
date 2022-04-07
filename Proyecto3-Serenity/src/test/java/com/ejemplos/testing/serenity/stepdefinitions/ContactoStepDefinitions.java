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



public class ContactoStepDefinitions{	
	
	WebDriver driver = Serenity.getDriver();

	@Given("un {actor} en la página Contacto")
	public void un_usuario_en_la_pagina_contacto(Actor actor) {
		actor.wasAbleTo(
			NavigateTo.theLucaContactPage()
		);
	}
    
	@When("redacta el formulario con el campo 'Nombre Completo' vacío")
	public void dejar_vacio_campo_nombre() {
		OnStage.theActorInTheSpotlight().attemptsTo(
			Enter.theValue("").into(By.id("nombre")),
			Enter.theValue("prueba@prueba.prueba").into(By.id("email")),
			Enter.theValue("+34 (420) 536-9869").into(By.id("teléfono")),
			Enter.theValue("Hola, buenas tardes").into(By.id("mensaje")),
			JavaScriptClick.on(By.id("chekedad")),
			JavaScriptClick.on(By.id("chekedprivacidad"))			
		);
	}
	
	@And("hace click en el botón 'Submit'")
	public void click_en_submit() {
		OnStage.theActorInTheSpotlight().attemptsTo(
			JavaScriptClick.on(By.id("submitButton"))			
		);
	}
	
	@Then("se muestra una alerta al respecto")
	public void alerta_por_nombre_vacio() {
		Actor actor = OnStage.theActorInTheSpotlight();
		Target username = Target.the("validacion").located(By.id("nombre"));
		actor.attemptsTo(
			Ensure.that(username.resolveFor(actor).getAttribute("validationMessage")).isNotEmpty()
		);
	}

	
	@When("clickea en los términos de uso")
    public void clickea_en_los_teminos_de_uso() {
		OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_PRIVACIDAD2)
		);
    }
	
	@Then("te redirige a la correspondiente página")
    public void te_redirige() {
		OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("privacidad")
    	);
    }
	
	@When("ese {actor} navega por la página Contacto")
    public void navega_por_la_pagina_contacto(Actor actor) {
    	
    	new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
    	actor.attemptsTo(
        		Scroll.to(By.xpath("//h1"))
        );
    }
	
	
	@Then("no tiene ningún impedimento respecto al contraste de texto-fondo")
    public void comprobar_contrastes_() {
    	
    	OnStage.theActorInTheSpotlight().attemptsTo(
                Open.browserOn().url("https://wave.webaim.org/report#/https://lucaticenterprise.herokuapp.com/contact.html")
        );
    	
    	Target FALLOS = Target.the("fallos contraste").located(By.xpath("//*[@id='contrast']/span"));
    	
    	OnStage.theActorInTheSpotlight().attemptsTo(Wait.until(
    			   WebElementQuestion.the(Button.located(By.id("viewdetails"))) , WebElementStateMatchers.isClickable()
    			).forNoMoreThan(30).seconds());
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(FALLOS.waitingForNoMoreThan(Duration.ofSeconds(5))).hasText("0")
        );

    }
	
	@Then("puede de leer toda la sección correctamente")
    public void letra_mayor_11_contacto(){
    	
    	Target CUALQUIER_ELEMENTO = Target.the("elementos html").locatedBy("//*");
    	List<WebElementFacade> elements = CUALQUIER_ELEMENTO.resolveAllFor(OnStage.theActorInTheSpotlight());
    	for (WebElementFacade htmlElement : elements) {
    		int tam = Integer.parseInt(htmlElement.getCssValue("font-size").split("px")[0].split("\\.")[0]);
			OnStage.theActorInTheSpotlight().attemptsTo(
	                Ensure.that(tam).isGreaterThan(11)
	        );
		}
    	
    }


}
