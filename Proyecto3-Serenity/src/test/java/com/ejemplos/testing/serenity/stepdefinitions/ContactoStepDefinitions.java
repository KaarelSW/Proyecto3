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

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ejemplos.testing.serenity.tasks.footer.Footer;
import com.ejemplos.testing.serenity.tasks.navbar.NavBar;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;



public class ContactoStepDefinitions{	

	@Given("un {actor} en la página Contacto")
	public void un_usuario_en_la_pagina_contacto(Actor actor) {
		actor.wasAbleTo(
			NavigateTo.theLucaContactPage()
		);
	}
    
	@Given("un {actor} en la página Home")
    public void is_in_home_page(Actor actor) {
        actor.wasAbleTo(
        		NavigateTo.theLucaHomePage()
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
	

	@When ("ese {actor} hace click en ir a Contacto")
	public void hace_click_pagina_Contacto(Actor actor) {
		
		actor.attemptsTo(JavaScriptClick.on(NavBar.CONTACTO_BUTTON));
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

	@Then("la página Contacto carga correctamente")
	public void pagina_Contacto_Carga_Correctamente(){
		
		WebDriver driver = Serenity.getDriver();
    	JavascriptExecutor j = (JavascriptExecutor) driver;
    	Ensure.that(j.executeScript("return document.readyState").toString()).contains("complete");
	}
	
}
