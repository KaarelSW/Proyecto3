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
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.OnStage;

import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

import com.ejemplos.testing.serenity.tasks.navigation.LucaHomePage;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @Given("un {actor} con discapacidad visual se encuentre en la seccion Home")
    public void usuario_con_discapacidad_visual_en_la_seccion_home(Actor actor) {
        actor.wasAbleTo(
        		NavigateTo.theLucaHomePage()
        );
    }
    
    @When("ese {actor} navega por la pagina")
    public void usuario_navega_por_la_pagina(Actor actor) {
        actor.attemptsTo(
        		Scroll.to(LucaHomePage.CLIENTES)
        );
    }
    
    
    @When("ese {actor} navega por la pagina ")
    public void ese_usuario_navega_por_la_pagina (Actor actor) {
        actor.attemptsTo(
        		Scroll.to(LucaHomePage.DESCRIPCION)
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
    
    @Then("hay un elemento footer")
    public void deberia_haber_un_elemento_footer() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(Footer.FOOTER_ITEM).isDisplayed()
    	);
    }
    
    @And("hay un enlace correcto a la página Privacidad")
    public void el_enlace_a_Privacidad_deberia_ser_correcto() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Hit.the(Keys.ENTER).into(Footer.LINK_PRIVACIDAD)
    	);  
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("privacidad"),
    			NavigateTo.theLucaHomePage()
    	);  
    }
    
    @And("hay un enlace correcto a la página Terminos")
    public void el_enlace_a_Terminos_deberia_ser_correcto() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_TERMINOS),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("terminos"),
    			NavigateTo.theLucaHomePage()
    	);  
    }
    
    @And("hay un enlace correcto a la página Contacto")
    public void el_enlace_a_Contacto_deberia_ser_correcto() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_CONTACTO),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("contact"),
    			NavigateTo.theLucaHomePage()
    	);  
    }
}
