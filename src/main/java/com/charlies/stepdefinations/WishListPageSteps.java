package com.charlies.stepdefinations;

import com.charlies.pages.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishListPageSteps {
	
	
	@Given("User navigate to wishlist page from myntra homepage")
	public void user_is_on_myntra_homepage() {
		HomePage homepg = new HomePage();
		homepg.clickOnWishList();
	    
	}

	@When("User clicks on wishlist option")
	public void user_clicks_on_wishlist_option() {
		HomePage homepg = new HomePage();
		homepg.clickOnWishList();
	   
	}

	@Then("User gets message to login to view wishlist")
	public void user_gets_message_to_login_to_view_wishlist() {
	   WishListPage wishlstpag = new WishListPage();
	   wishlstpag.verifyIfWishListContainsText("Login to view items in your wishlist.");
	}


	@Then("User get login option to navigate to login page")
	public void user_get_login_option_to_navigate_to_login_page() {
		WishListPage wishlstpag = new WishListPage();
		wishlstpag.clickOnLogin(wishlstpag.wishListLoginButton);
		LoginPage loginpg = new LoginPage();
		loginpg.verifyLoginURL("https://www.myntra.com/login?referer=https://www.myntra.com/wishlist");
}

}
