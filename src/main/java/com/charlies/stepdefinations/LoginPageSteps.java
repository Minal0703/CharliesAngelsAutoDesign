package com.charlies.stepdefinations;

import com.charlies.pages.HomePage;
import com.charlies.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	@Given("User is on myntra homepage")
	public void user_is_on_myntra_homepage() {
		HomePage homepg = new HomePage();
		homepg.clickOnUserProfile();
	    
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		LoginPage loginpg = new LoginPage();
		loginpg.clickOnLoginButton(loginpg.loginButton);
	}

	@Then("Login field should be marked with Asterik sign")
	public void login_field_should_be_marked_with_asterik_sign() {
		LoginPage loginpg = new LoginPage();
		loginpg.verifyTextContainsAsterik("*");
	}




}
