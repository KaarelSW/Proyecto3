package com.ejemplos.testing.serenity.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

import com.ejemplos.testing.serenity.tasks.navigation.LucaHomePage;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;
import com.ejemplos.testing.serenity.tasks.search.LookForInformation;

import org.openqa.selenium.By;
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

    @When("el {actor} navega por la página")
    public void navega_por_la_pagina(Actor actor) {
        actor.attemptsTo(
        		Scroll.to(LucaHomePage.CLIENTES)
        );
    }

    @Then("{actor} visualiza sección de clientes")
    public void visualiza_seccion_de_clientes(Actor actor) {
        actor.attemptsTo(
                Ensure.that(LucaHomePage.CLIENTES).hasText("Algunos de nuestros clientes")
        );
    }

    @When("el {actor} navega por la página ")
    public void el_usuario_navega_por_la_página (Actor actor) {
        actor.attemptsTo(
        		Scroll.to(LucaHomePage.DESCRIPCION)
        );
    }

    @Then("{actor} visualiza descripción y valores de la empresa")
    public void visualiza_descripción_y_valores_de_la_empresa(Actor actor) {
        actor.attemptsTo(
                Ensure.that(LucaHomePage.DESCRIPCION).isDisplayed()
        );
        
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
    
    
        
    @Given("con discapacidad en la sección Home")
    public void usuario_con_discapacidad_visual_en_la_seccion_home(Actor actor) throws Exception {
        actor.wasAbleTo(
        		NavigateTo.theLucaHomePage()
        );
    }

    @When("navega por la sección Home")
    public void usuario_navega_por_la_seccion_home(Actor actor, String term) throws Exception{
        actor.attemptsTo(
        		NavigateTo.theLucaHomePage()
        );
    }
    
    @Then("puede acceder a los atributos alt de las imágenes")
    public void usuario_puede_acceder_a_los_atributos_alt_de_las_imagenes()throws Exception{
    	Target cualquierimagen = Target.the("imagenes home").locatedBy("//img");
    	List <WebElementFacade> imagenes = cualquierimagen.resolveAllFor(OnStage.theActorInTheSpotlight());
    	for (WebElementFacade imagen : imagenes) {
    		OnStage.theActorInTheSpotlight().attemptsTo(
    				Ensure.that(imagen.getAttribute("alt")).hasSizeGreaterThan(0)
    				);
    	}
    }  
}
