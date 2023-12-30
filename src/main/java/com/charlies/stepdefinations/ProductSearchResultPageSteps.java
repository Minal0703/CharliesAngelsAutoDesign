package com.charlies.stepdefinations;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.Keys;

import com.charlies.pages.HomePage;
import com.charlies.pages.SearchResultPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchResultPageSteps {
	
	
	@Given("User enters mango brand in search component")
	public void user_enters_mango_brand_in_search_component() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Mango");
	}

	@When("User clicks on glass magnifier")
	public void user_clicks_on_glass_magnifier() {
		 SearchResultPage searchrsltpg = new SearchResultPage();
		 searchrsltpg.clicksOnGlassMagnifier();
		}
	


	@Then("On product search result page user should sort product by high to low price.")
	public void on_product_search_result_page_user_should_sort_product_by_high_to_low_price(){
	    SearchResultPage searchrsltpg = new SearchResultPage();
	    searchrsltpg.hoverOnSortByDropDown();
	    searchrsltpg.clickOnHighToLow();
	    searchrsltpg.verifyProductPriceBetweenHighToLow();
	}
	@Then("On product search result page user should sort product by low to high price")
	public void on_product_search_result_page_user_should_sort_product_by_low_to_high_price(){
	    SearchResultPage searchrsltpg = new SearchResultPage();
	    searchrsltpg.hoverOnSortByDropDown();
	    searchrsltpg.clickOnLowToHigh();
	    searchrsltpg.verifyProductPriceBetweenLowToHigh();
	}
	
	@And("User selects dresses filter from leftside menu")
	public void user_selects_dresses_filter_from_leftside_menu() {
		SearchResultPage searchrsltpg = new SearchResultPage();
		searchrsltpg.selectCheckBox(searchrsltpg.dressFilter);

	}
	
	@Then("All the Mango dresses should get filter out")
	public void all_the_mango_dresses_should_get_filter_out() {
		SearchResultPage searchrsltpg = new SearchResultPage();
		searchrsltpg.verifyDressNameContains("Dress");
	    
	}
	
	@And("User selects dresses & colour filter from leftside menu")
	public void user_selects_dresses_and_colour_filter() {
		SearchResultPage searchrsltpg = new SearchResultPage();
		searchrsltpg.selectCheckBox(searchrsltpg.dressFilter);
		searchrsltpg.selectCheckBox(searchrsltpg.colorFilter);
		
	}
	
	@Then("All the Mango dresses should get filter out on the basis of colour")
	public void dresses_should_get_filter_out_on_the_basis_of_colour() {
		SearchResultPage searchrsltpg = new SearchResultPage();
		searchrsltpg.verifyURL("https://www.myntra.com/mango?f=Categories%3ADresses%3A%3AColor%3ABlack_36454f");

	}
	
	
}
