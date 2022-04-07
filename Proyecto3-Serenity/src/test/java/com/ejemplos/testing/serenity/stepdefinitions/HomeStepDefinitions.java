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

import com.ejemplos.testing.serenity.tasks.navigation.LucaHomePage;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ejemplos.testing.serenity.tasks.footer.Footer;
import com.ejemplos.testing.serenity.tasks.navbar.NavBar;


public class HomeStepDefinitions{	

    @Given("un {actor} accede a la página Home")
    public void is_in_home_page(Actor actor) {
        actor.wasAbleTo(
        		NavigateTo.theLucaHomePage()
        );
    }
    
    WebDriver driver = Serenity.getDriver();
    String[] urls = new String[5];
    
    @When("ese {actor} clica en todos los links del navbar")
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

    @When("ese {actor} navega por la página ")
    public void ese_usuario_navega_por_la_página (Actor actor) {
    	
    	new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
    	actor.attemptsTo(
        		Scroll.to(By.xpath("//h1"))
        	
        );
    }

    @Then("{actor} visualiza sección de clientes")
    public void visualiza_seccion_de_clientes(Actor actor) {
        actor.attemptsTo(
                Ensure.that(LucaHomePage.CLIENTES).hasText("Algunos de nuestros clientes")
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

    @Then("es capaz de obtener todos los textos alt de los elementos img de la pagina")
    public void usuario_puede_acceder_a_los_atributos_alt_de_las_imagenes(){
    	Target cualquierimagen = Target.the("imagenes home").locatedBy("//img");
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
 
    @Then("visualiza la página sin problemas de contraste")
    public void comprobar_contrastes() {
    	
    	OnStage.theActorInTheSpotlight().attemptsTo(
                Open.browserOn().url("https://wave.webaim.org/report#/https://lucaticenterprise.herokuapp.com/home.html")
        );
    	
    	Target FALLOS = Target.the("fallos contraste").located(By.xpath("//*[@id='contrast']/span"));
    	
    	OnStage.theActorInTheSpotlight().attemptsTo(Wait.until(
    			   WebElementQuestion.the(Button.located(By.id("viewdetails"))) , WebElementStateMatchers.isClickable()
    			).forNoMoreThan(30).seconds());
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(FALLOS.waitingForNoMoreThan(Duration.ofSeconds(5))).hasText("0")
        );

    }
    
    @Then("es capaz de leer cualquier texto de la página Home")
    public void letra_mayor_11_Home(){    	
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

    @Then("hay un elemento footer en la página Home")
    public void hay_un_elemento_footer_en_la_pagina_home() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(Footer.FOOTER_ITEM).isDisplayed()
    	);
    }
    
    @And("hay un enlace correcto a la página Privacidad de Home")
    public void el_enlace_a_Privacidad_Home_es_correcto() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_PRIVACIDAD),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("privacidad"),
    			NavigateTo.theLucaHomePage()
    	);  
    }
    
    @And("hay un enlace correcto a la página Terminos de Home")
    public void el_enlace_a_Terminos_Home_es_correcto() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_TERMINOS),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("terminos"),
    			NavigateTo.theLucaHomePage()
    	);  
    }
    
    @And("hay un enlace correcto a la página Contacto de Home")
    public void el_enlace_a_Contacto_Home_es_correcto() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_CONTACTO),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("contact"),
    			NavigateTo.theLucaHomePage()
    	);  
    }
    
}
