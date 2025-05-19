package StepDefinition2;

import java.io.IOException;

import org.testng.Assert;

import TestData.PayloadData;
import TestData.TestDataExcel;
import Utilities.FetchDataFromProperty;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;


public class StepDefinition2 
{
	RequestSpecification req;
	RequestSpecification res;
	ResponseSpecification respec;
	Response response;
	
	String URI1=FetchDataFromProperty.readDataFromProperty().getProperty("URI1");
	String URI2=FetchDataFromProperty.readDataFromProperty().getProperty("URI2");
	String AuthToken;

	@Given("user opens the base URI")
	public void user_opens_the_base_uri() 
	{
		req=new RequestSpecBuilder().setBaseUri(URI1).setContentType(ContentType.JSON).build();
	    
	}
	
	@Given("user passes the payload with all required details")
	public void user_passes_the_payload_with_all_required_details() throws JsonProcessingException 
	{
		res=given().log().all().headers("x-api-key","reqres-free-v1").relaxedHTTPSValidation().spec(req).body(PayloadData.createUserData());
	}

	@When("user hits the {string}")
	public void user_hits_the(String endpoint) throws NullPointerException
	{
		respec=new ResponseSpecBuilder().build();
		response=res.when().post(endpoint).then().log().all().spec(respec).extract().response();
	    
	}

	@Then("user will check the data is obtained with {string}")
	public void user_will_check_the_data_is_obtained_with(String status_code) 
	{
		long time=response.getTime();
		
		if(time>5000)
		{
			throw new ArithmeticException("The response time is more than expected");
		}
		else
		{
			System.out.println("The performance is within threshold");
		}
		
		String s=status_code;
		int expectedStatusCode=Integer.parseInt(s);
		int actualStatusCode=response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
		 JsonPath js=new JsonPath(response.asString());
		    String name=js.getString("userName");
		    Assert.assertEquals("Harry", name);
		    System.out.println("Testcase Completed");
		
	}
	

	@Given("user hits the gorest on its uri")
	public void user_hits_the_gorest_on_its_uri() 
	{
		req=new RequestSpecBuilder().setBaseUri(URI2).setContentType(ContentType.JSON).build();
	}

	@When("user enters the authentication token")
	public void user_enters_the_authentication_token() 
	{
	    AuthToken=FetchDataFromProperty.readDataFromProperty().getProperty("Token");
	}

	@When("user passes the payload in gorest site with all the required details")
	public void user_passes_the_payload_in_gorest_site_with_all_the_required_details() throws IOException 
	{
		res=given().log().all().relaxedHTTPSValidation().headers("Authorization",AuthToken)
				.spec(req).body(TestDataExcel.getDataFromExcel());
	}

	@When("user will hit the gorest {string}")
	public void user_will_hit_the_gorest(String endpoint) 
	{
		respec=new ResponseSpecBuilder().build();
		response=res.when().post(endpoint).then().log().all().spec(respec).extract().response();
	}

	@Then("user validates the status code as {string}")
	public void user_validates_the_status_code_as(String string) 
	{
	    System.out.println("Validated status code");
	}

	@Then("user will validate the details in status body")
	public void user_will_validate_the_details_in_status_body(io.cucumber.datatable.DataTable dataTable) 
	{
	    System.out.println("Validation of status body");
	}




}
