package com.ejemplos.testing.serenity.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import com.ejemplos.testing.serenity.tasks.navigation.LucaHomePage;
import com.ejemplos.testing.serenity.tasks.navigation.NavigateTo;
import com.ejemplos.testing.serenity.tasks.search.LookForInformation;
import com.ejemplos.testing.serenity.tasks.search.WikipediaArticle;

/*
 * The sample code uses the Screenplay pattern. 
 * The Screenplay pattern describes tests in terms of actors and the tasks they perform. 
 * Tasks are represented as objects performed by an actor, rather than methods. 
 * This makes them more flexible and composable, at the cost of being a bit more wordy. 
 */
//Añadimos lo de nuestro .feature

public class HomeStepDefinitions{	

    @Given("{actor} en la sección Home")
    public void usuario_en_la_sección_Home(Actor actor) {
        actor.wasAbleTo(
        		NavigateTo.theLucaHomePage()
        );
    }

    @When("{actor} navega por la página")
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

    @When("{actor} navega por la página ")
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
    
    
}
