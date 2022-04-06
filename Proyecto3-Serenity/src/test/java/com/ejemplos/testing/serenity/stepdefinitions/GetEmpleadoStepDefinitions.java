package com.ejemplos.testing.serenity.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetEmpleadoStepDefinitions{
	
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
    
//Feature: Consultar un empleado. Escenario 1
	
    @Given("^un administrador está logueado$")
    public void un_administrador_logueado() throws Exception {
        RestAssured.baseURI  = url;
        request = RestAssured.given();
    }
    
    Response response;
    @When("pide los datos de un empleado específico$")
    public void realiza_una_peticion_a_la_API() throws Exception {
    	int idEmpleado = 1;
    	response = request.get("/empleados/"+idEmpleado);
    }

    @Then("^se obtiene un JSON con la información del empleado$")
    public void se_obtiene_informacion_en_formato_JSON() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	assertTrue(json instanceof JSONObject);
    }
    
//Feature: Consultar un empleado. Escenario 2
    
    @Then("^se devuelve un objeto cuyo número de propiedades coincide con las de empleado$")
    public void devuelve_un_objeto_con_datos_cuyo_numero_de_propiedades_coincide_con_las_de_empleado() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	Assert.assertTrue(json.length() == 16);
    }
    
//Feature: Consultar un empleado. Escenario 3
    
    @Then("^se devuelve un empleado cuya propiedad nombre está compuesta por caracteres alfabéticos$")
    public void devuelve_un_objeto_cuyo_nombre_solo_tiene_letras() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	String nombre = json.getJSONObject("data").get("nombre").toString();
    	Assert.assertTrue(Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚ]*$", nombre));
    }
    
//Feature: Consultar un empleado. Escenario 4    
    
    @Then("^se devuelve un empleado cuya propiedad apellido está compuesta por caracteres alfabéticos$")
    public void devuelve_un_objeto_cuyo_apellido_solo_tiene_letras() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	String apellido = json.getJSONObject("data").get("apellido").toString();
    	Assert.assertTrue(Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚ]*$", apellido));
    }
    
//Feature: Consultar un empleado. Escenario 5     
    
    @Then("^se devuelve un empleado cuya propiedad edad es un entero$")
    public void devuelve_un_objeto_cuya_edad_es_un_entero() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	String edad = json.getJSONObject("data").get("edad").toString();
    	Assert.assertTrue(Pattern.matches("^[0-9]*$", edad));
    }
    
//Feature: Consultar un empleado. Escenario 6     
    
    @Then("^se devuelve un empleado cuya propiedad edad es superior a 18$")
    public void devuelve_un_objeto_cuya_edad_es_mayor_que_18() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	int edad = Integer.parseInt(json.getJSONObject("data").get("edad").toString());
    	Assert.assertTrue(18 <= edad);
    }
    
//Feature: Consultar un empleado. Escenario 7     
    
    @Then("^se devuelve un empleado cuya propriedad correo tiene un formato correcto$")
    public void devuelve_un_objeto_cuya_propiedad_correo_tiene_formato_correcto() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	String email = json.getJSONObject("data").get("email").toString();
    	Assert.assertTrue(Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email));
    }
    
//Feature: Consultar un empleado. Escenario 8     
    
    @Then("^se devuelve un empleado cuya propiedad registered contiene una fecha anterior o igual a la actual$")
    public void devuelve_un_objeto_cuya_propiedad_registered_contiene_fecha_no_futura() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	String[] fechaArr = json.getJSONObject("data").get("registered").toString().split("T");
    	String fecha = fechaArr[0];
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDate fechaRegistro = LocalDate.parse(fecha, formatter);
    	LocalDate fechaActual =LocalDate.now();
    	System.out.println(formatter.toString());
    	System.out.println(fechaRegistro.toString());
    	Assert.assertFalse(fechaRegistro.isAfter(fechaActual));
    }
}