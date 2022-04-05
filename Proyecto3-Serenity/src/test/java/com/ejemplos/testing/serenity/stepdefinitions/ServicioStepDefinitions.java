package com.ejemplos.testing.serenity.stepdefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ServicioStepDefinitions{

	
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
    
    
   
    @Given("un {actor} accede a la página Servicios")
    public void is_in_service_page(Actor actor) {
        actor.wasAbleTo(
        		NavigateTo.theLucaServicePage()
        );

    }
    
    WebDriver driver = Serenity.getDriver();
    String[] urls = new String[4];
    
    @When("el contenido de la pagina se carga")
    public void deberia_cargar_el_contenido() {
    	JavascriptExecutor j = (JavascriptExecutor) driver;
    	Ensure.that(j.executeScript("return document.readyState").toString()).contains("complete");
    }
    
    @Then("hay un elemento footer")

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
