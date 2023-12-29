package com.charlies.stepdefinations;

import org.apache.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAPITestingOperation {
	
	String url = "https://reqres.in/api/users";
	
	@Given("I Set POST employee service api endpoint")
    public void setPostEndpoint(){   
        System.out.println("Add URL :"+ url);
    }
	
	@When ("Send a POST HTTP request with {string} and {string}")
    public void sendPostRequest(String username,String job){
       
		String jsonBody="{\r\n"
				+ "    \"name\": \""+username+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
        System.out.println("\n\n" + jsonBody);
      Response response=RestAssured.given().when().body(jsonBody).post();
    }
	
}
