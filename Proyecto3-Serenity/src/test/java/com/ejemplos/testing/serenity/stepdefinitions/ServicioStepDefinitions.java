package com.ejemplos.testing.serenity.stepdefinitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;


public class ServicioStepDefinitions{

	
    @Given("{actor} un usuario se encuentra en la web")
    public void navigate_To_Luca_Service_Page(Actor actor) {
    
    }

    @When("{actor} el usuario accede sección Servicios {string}")
    public void acceder_Seccion_Servicios(Actor actor) {
		
        actor.attemptsTo(
                NavigateTo.theLucaServicePage()
        );
        
    }

    @Then("se carga la página Servicios y se muestran los contenidos correctamente")
    public void deberia_cargar_y_mostrar_contenido_correctamente(Actor actor) {

    	WebDriver driver = Serenity.getDriver();
    	JavascriptExecutor j = (JavascriptExecutor) driver;
    	Ensure.that(j.executeScript("return document.readyState").toString()).contains("complete");
    	
    }
}
