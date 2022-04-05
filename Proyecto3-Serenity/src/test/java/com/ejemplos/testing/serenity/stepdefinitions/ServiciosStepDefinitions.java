package com.ejemplos.testing.serenity.stepdefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.ejemplos.testing.serenity.tasks.navigation.LucaServicesPage;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ServiciosStepDefinitions{

	
    @Given("un usuario se encuentra en la web")
    public void navigate_To_Luca_Service_Page() {
    
    }

    @When("el {actor} accede a la sección Servicios")
    public void acceder_Seccion_Servicios(Actor actor) {
		
        actor.attemptsTo(
                NavigateTo.theLucaServicePage()
        );
        
    }

    @Then("se carga la página Servicios y se muestran los contenidos correctamente")
    public void deberia_cargar_y_mostrar_contenido_correctamente() {

    	WebDriver driver = Serenity.getDriver();
    	JavascriptExecutor j = (JavascriptExecutor) driver;
    	Ensure.that(j.executeScript("return document.readyState").toString()).contains("complete");
    	
    }
    
    
// 
    
    @Given("el {actor} accede a la página Servicios")
    public void deberia_ir_a_la_pagina_servicios(Actor actor) {
        actor.wasAbleTo(
        		NavigateTo.theLucaServicePage()
        );

    }
    
    WebDriver driver = Serenity.getDriver();
    
    
    @When("el contenido de la pagina se carga")
    public void deberia_cargar_el_contenido() {
    	JavascriptExecutor j = (JavascriptExecutor) driver;
    	Ensure.that(j.executeScript("return document.readyState").toString()).contains("complete");
    }
    String[] urls = new String[4];
    @Then("hay un elemento footer")
    public void deberia_haber_un_elemento_footer() {
    	
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
    
 //
    
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

