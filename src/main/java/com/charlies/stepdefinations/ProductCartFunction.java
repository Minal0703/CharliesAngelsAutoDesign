package com.charlies.stepdefinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.charlies.base.Config;
import com.charlies.keywords.keywords;
import com.charlies.pages.AddToBagPage;
import com.charlies.pages.HomePage;
import com.charlies.pages.SearchResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductCartFunction {
	
	Logger LOG=Logger.getLogger(ProductCartFunction.class);
	@Given("Enter kalini in search component")
	public void searchKaliniProductInSearchComponent() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("kalini",Keys.ENTER);
	}
	
	@When("user clicks on Kurta with Trousers & Dupatta")
	public void clickOnKurtaWTrouser() {
		SearchResultPage searchResultPage=new SearchResultPage();
		searchResultPage.clickOnKurtaWithTrouser();
	}
	
	@Then("Switch to newly opened PIP")
	public void switchToPIP() {
		SearchResultPage searchResultPage=new SearchResultPage();
		searchResultPage.switchToPIPPage("Buy KALINI Bandhani Printed Regular Kurta With Trousers & Dupatta  - Kurta Sets for Women 24467524 | Myntra");
	}
	
	@Then("Select Size S")
	public void selectKurtaSize() {
		AddToBagPage addToBagPage=new AddToBagPage();
		addToBagPage.selectKurtaSize();
	}
	
	@Then("Click on Add To Bag")
	public void clickOnAddToBagToAddProductInBag() {
		AddToBagPage addToBagPage=new AddToBagPage();
		
		keywords keyword=new keywords();
		keyword.scrollDown();
		addToBagPage.clickOnAddToBag();
		LOG.info("Item Added To Cart");
		}
	
	@Then("Select Prize Filter and apply value")
	public void applyPrizeFilterCheckbox() {
		AddToBagPage addToBagPage=new AddToBagPage();
		addToBagPage.applyPrizeFilter();
	}
}
