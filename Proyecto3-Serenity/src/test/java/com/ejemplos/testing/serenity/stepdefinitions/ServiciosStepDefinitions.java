package com.ejemplos.testing.serenity.stepdefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.ejemplos.testing.serenity.tasks.navigation.LucaServicesPage;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ServiciosStepDefinitions{

//Feature: Consultar la página Servicios. Escenario 1
	
    @Given("un usuario se encuentra en la web")
    public void navigate_To_Luca_Service_Page() {
    
    }

    @When("el {actor} accede sección Servicios")
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
    
//Feature: Consultar la página Servicios. Escenario 2
    
    @Given("el {actor} accede a la página Servicios")
    public void acceder_a_la_Pagina_Servicios(Actor actor) {		
        actor.wasAbleTo(
                NavigateTo.theLucaServicePage()
        );        
    }
    
    @When("el contenido de la página se carga")
    public void deberia_cargar_correctamente() {
    	WebDriver driver = Serenity.getDriver();
    	JavascriptExecutor j = (JavascriptExecutor) driver;
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(j.executeScript("return document.readyState").toString()).contains("complete")    	
    	);
    }
    
    @Then("se muestra al menos un elemento de tipo acordeón")
    public void deberia_mostrar_un_acordeon() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(LucaServicesPage.ACCORDION).isDisplayed()
        );
    }
    
}

