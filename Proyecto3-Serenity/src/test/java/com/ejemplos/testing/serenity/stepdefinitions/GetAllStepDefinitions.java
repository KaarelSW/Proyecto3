package com.ejemplos.testing.serenity.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.json.JSONArray;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetAllStepDefinitions{
	
	RequestSpecification request;
	static String url;
	
	@BeforeAll
	public static void Before_All() {
		Properties props = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("serenity.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                 if (in != null) {
                     in.close();
                 }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        url = props.getProperty("baseurl");
	}          
    
//Feature: Consultar todos los empleados. Escenario 1
	
    @Given("^un administrador$")
    public void un_administrador_logueado() throws Exception {
        RestAssured.baseURI  = url;
        request = RestAssured.given();
    }
    
    Response response;
    @When("hace una petición a la API$")
    public void realiza_una_peticion_a_la_API() throws Exception {
    	response = request.get("/empleados");
    }

    @Then("^obtiene información en formato JSON$")
    public void se_obtiene_informacion_en_formato_JSON() throws Exception {
    	//System.out.println(response.asPrettyString());
    	JSONArray json = new JSONArray(response.body().asString());
    	assertTrue(json instanceof JSONArray);
    }
    
//Feature: Consultar todos los empleados. Escenario 2
	
    int empleadosEsperados;
    @And("^sabe cuántos empleados existen$")
    public void conoce_el_numero_de_empleados() {
    	empleadosEsperados = 100;
    }

    @Then("^recibe la información de dichos empleados en formato JSON$")
    public void se_obtiene_informacion__de_todos_los_empleados_en_formato_JSON() throws Exception {
    	JSONArray json = new JSONArray(response.body().asString());     
    	Assert.assertEquals(empleadosEsperados, json.length());
    }
}
