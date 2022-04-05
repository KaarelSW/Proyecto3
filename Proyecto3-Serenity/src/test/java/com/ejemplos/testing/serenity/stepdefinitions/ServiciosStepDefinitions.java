package com.ejemplos.testing.serenity.stepdefinitions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ejemplos.testing.serenity.tasks.navigation.LucaServicesPage;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;

import com.ejemplos.testing.serenity.tasks.footer.Footer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

public class ServiciosStepDefinitions{

	
    @Given("un {actor} se encuentra en la web")
    public void navigate_To_Luca_Service_Page(Actor actor) {
    
    }
    
    @Given("un {actor} accede a la página Servicios")
    public void usuario_en_la_sección_Servicio(Actor actor) {
    	actor.wasAbleTo(
        		NavigateTo.theLucaServicePage()
        );
    }
    
    WebDriver driver = Serenity.getDriver();

    @When("ese {actor} accede a la sección Servicios")
    public void acceder_Seccion_Servicios(Actor actor) {
		
        actor.attemptsTo(
                NavigateTo.theLucaServicePage()
        );
        
    }
    
    @When("ese {actor} navega por la página")
    public void servicios_esta_cargado(Actor actor) {
    	
    	new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
    	actor.attemptsTo(
        		Scroll.to(By.xpath("//h1"))
        );
    }
    
    @Then("se carga la página Servicios y se muestran los contenidos correctamente")
    public void deberia_cargar_y_mostrar_contenido_correctamente() {

    	WebDriver driver = Serenity.getDriver();
    	JavascriptExecutor j = (JavascriptExecutor) driver;
    	Ensure.that(j.executeScript("return document.readyState").toString()).contains("complete");
    	
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
    
    @Then("es capaz de leer cualquier texto de la página")
    public void letra_mayor_11(){
    	
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
    
    @Then("no tiene ningún impedimento respecto a los contrastes de texto-fondo")
    public void comprobar_contrastes_() {
    	
    	OnStage.theActorInTheSpotlight().attemptsTo(
                Open.browserOn().url("https://wave.webaim.org/report#/https://lucaticenterprise.herokuapp.com/service.html")
        );
    	
    	Target FALLOS = Target.the("fallos contraste").located(By.xpath("//*[@id='contrast']/span"));
    	
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			Ensure.that(FALLOS.waitingForNoMoreThan(Duration.ofSeconds(5))).hasText("2")
        );
    	
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
    			NavigateTo.theLucaServicePage()
    	);  
    }
    
    @And("hay un enlace correcto a la página Terminos")
    public void el_enlace_a_Terminos_deberia_ser_correcto() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_TERMINOS),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("terminos"),
    			NavigateTo.theLucaServicePage()
    	);  
    }
    
    @And("hay un enlace correcto a la página Contacto")
    public void el_enlace_a_Contacto_deberia_ser_correcto() {
    	OnStage.theActorInTheSpotlight().attemptsTo(
    			JavaScriptClick.on(Footer.LINK_CONTACTO),
    			Ensure.thatTheCurrentPage().currentUrl().contains("lucaticenterprise.herokuapp"),
    			Ensure.thatTheCurrentPage().currentUrl().contains("contact"),
    			NavigateTo.theLucaServicePage()
    	);  
    }
    
}


