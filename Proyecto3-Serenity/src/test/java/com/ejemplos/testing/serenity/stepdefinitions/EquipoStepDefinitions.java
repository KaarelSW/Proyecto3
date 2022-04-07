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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ejemplos.testing.serenity.tasks.footer.Footer;
import com.ejemplos.testing.serenity.tasks.navbar.NavBar;
import com.ejemplos.testing.serenity.tasks.navigation.LucaEquipoPage;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;



public class EquipoStepDefinitions{	
	
	WebDriver driver = Serenity.getDriver();

    @Given("un {actor} accede a la sección Equipo")
    public void is_in_team_page(Actor actor) {
        actor.wasAbleTo(
        		NavigateTo.theLucaEquipoPage()
        );
    }
    
    @When("ese {actor} navega por la página Equipo")
    public void ese_usuario_navega_por_la_página (Actor actor) {
    	
    	new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
    	actor.attemptsTo(
        		Scroll.to(By.xpath("//h1"))
        	
        );
    }
    
    @Then("es capaz de leer cualquier texto de la página Equipo")
    public void letra_mayor_11_Equipo(){    	
    	//Comprobar que todos los elementos con font-size, esta es mayor de 11
    	Target CUALQUIER_ELEMENTO = Target.the("elementos html").locatedBy("//*");
    	List<WebElementFacade> elements = CUALQUIER_ELEMENTO.resolveAllFor(OnStage.theActorInTheSpotlight());
    	for (WebElementFacade htmlElement : elements) {
    		int tam = Integer.parseInt(htmlElement.getCssValue("font-size").split("px")[0].split("\\.")[0]);
			OnStage.theActorInTheSpotlight().attemptsTo(
	                Ensure.that(tam).isGreaterThan(11)
	        );
		}    	
    }
    
    @Then("no tiene ningún impedimento respecto a los contrastes de texto-fondo en Equipo")
    public void comprobar_contrastes() {
    	
    	OnStage.theActorInTheSpotlight().attemptsTo(
                Open.browserOn().url("https://wave.webaim.org/report#/https://lucaticenterprise.herokuapp.com/equipo.html")
        );
    	
    	Target FALLOS = Target.the("fallos contraste").located(By.xpath("//*[@id='contrast']/span"));
    	
    	OnStage.theActorInTheSpotlight().attemptsTo(Wait.until(
    			   WebElementQuestion.the(Button.located(By.id("viewdetails"))) , WebElementStateMatchers.isClickable()
    			).forNoMoreThan(30).seconds());
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(FALLOS.waitingForNoMoreThan(Duration.ofSeconds(5))).hasText("0")
        );
    }
    
    @Then("se muestra la sección con la información de los principales objetivos de la empresa")
    public void se_muestra_la_seccion_con_la_informacion_de_la_empresa(){ 
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(LucaEquipoPage.OBJETIVOS).isDisplayed()
        );
    }
    

    @Then("hay un elemento footer en Equipo")
    public void hay_un_elemento_footer_en_la_pagina_equipo() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(Footer.FOOTER_ITEM).isDisplayed()
    	);
    }

    @And("los enlaces del footer de equipo funcionan correctamente")
    public void los_enlaces_furulan() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_PRIVACIDAD),
    			Ensure.thatTheCurrentPage().currentUrl().contains("politica-de-privacidad"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("privacidad"),
    			NavigateTo.theLucaHomePage(),
    			JavaScriptClick.on(Footer.LINK_TERMINOS),
    			Ensure.thatTheCurrentPage().currentUrl().contains("terminos"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("terminos"),
    			NavigateTo.theLucaHomePage(),
    			JavaScriptClick.on(Footer.LINK_CONTACTO),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("contact"),
    			NavigateTo.theLucaHomePage()
    	);
    }
    
    @Then("visualiza una barra de navegación en la página Equipo")
    public void visualiza_una_barra_de_navegacion_en_Equipo() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(NavBar.RIGHT_NAVBAR_ITEM).isDisplayed()
        );
    }
    
    @And("hay un enlace correcto a la página Privacidad de Equipo")
    public void el_enlace_a_Privacidad_deberia_ser_correcto_en_Equipo() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_PRIVACIDAD),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("privacidad"),
    			NavigateTo.theLucaServicePage()
    	);  
    }
    
    @And("hay un enlace correcto a la página Terminos de Equipo")
    public void el_enlace_a_Terminos_deberia_ser_correcto_en_Equipo() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_TERMINOS),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("terminos"),
    			NavigateTo.theLucaServicePage()
    	);  
    }
    
    @And("hay un enlace correcto a la página Contacto de Equipo")
    public void el_enlace_a_Contacto_deberia_ser_correcto_en_Equipo() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_CONTACTO),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("contact"),
    			NavigateTo.theLucaServicePage()
    	);  
    }

    @Then("es capaz obtener todos textos alt de los elementos img de la página equipo")
    public void usuario_puede_acceder_a_los_atributos_alt_de_las_imagenes(){
    	Target cualquierimagen = Target.the("imagenes equipo").locatedBy("//img");
    	List <WebElementFacade> imagenes = cualquierimagen.resolveAllFor(OnStage.theActorInTheSpotlight());
    	for (WebElementFacade imagen : imagenes) {
    		OnStage.theActorInTheSpotlight().attemptsTo(
    				Ensure.that(imagen.getAttribute("alt")).isNotBlank(),
    				Ensure.that(imagen.getAttribute("alt")).isNotEmpty(),
    				Ensure.that(imagen.getAttribute("alt")).isNotNull(),
    				Ensure.that(imagen.getAttribute("alt")).matches(".*[aeiou].*")
    				);
    	}
    } 
    
    @Then("se muestra la sección con la información del Equipo")
    public void se_muestra_la_seccion_con_el_equipo__de_la_empresa(){ 
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(LucaEquipoPage.EQUIPO).isDisplayed()
        );
    }
}
