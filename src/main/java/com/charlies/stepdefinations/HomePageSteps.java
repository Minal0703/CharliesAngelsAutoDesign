package com.charlies.stepdefinations;

import com.charlies.pages.CheckOutPage;
import com.charlies.pages.HomePage;
import com.charlies.pages.MenMenuPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class HomePageSteps {

	@When("User hovers on mens menu page")
	public void user_hovers_on_mens_menu_page() {
		HomePage Onhomepg = new HomePage();
		Onhomepg.mouseHoverTo();
			
	}

	@And("clicks on casual shirts")
	public void clicks_on_casual_shirts() {
		HomePage Onhomepg = new HomePage();
		Onhomepg.clickOnProducts(Onhomepg.shirtOption);
		
	}

	@Then("User successfully navigates to mens clothing page")
	public void user_successfully_navigates_to_mens_clothing_page() {
		MenMenuPage OnmenMenuPg = new MenMenuPage();
		OnmenMenuPg.verifyTextContains();
		
	}
	
	@And("clicks on casual shirts to add one shirt into bag")
	public void user_clicks_on_casualshirt_to_add_one_shirt_in_bag() throws InterruptedException{
		HomePage Onhomepg = new HomePage();
		MenMenuPage OnmenMenuPg = new MenMenuPage();
		Onhomepg.clickOnProducts(Onhomepg.shirtOption);
		OnmenMenuPg.clickOnProducts(OnmenMenuPg.finalProduct);
		OnmenMenuPg.switchToWindow();
		OnmenMenuPg.selectSize(OnmenMenuPg.size);
		OnmenMenuPg.clickOnProducts(OnmenMenuPg.addToBag);
		OnmenMenuPg.clickOnProducts(OnmenMenuPg.goToBag);
		
	}
	
	@Then("User is successful adding product into bag")
	public void User_is_successful_adding_product_into_bag() {
		MenMenuPage OnmenMenuPg = new MenMenuPage();
		OnmenMenuPg.verifyAddProductContains();
	}
	
	@And("User clicks on remove button")
	public void user_clicks_on_remove_button(){
		CheckOutPage OnCheckoutpg = new CheckOutPage();
		OnCheckoutpg.clickOnCartMessage();
		OnCheckoutpg.clickOnRemove(OnCheckoutpg.removeOption);
		OnCheckoutpg.clickOnRemove(OnCheckoutpg.removeOption2);

	} 
	
	@Then("User is able to remove product from bag")
	public void user_is_able_to_remove_product_from_bag() {
		CheckOutPage OnCheckoutpg = new CheckOutPage();
		OnCheckoutpg.verifyCartMessage();
		
	}

}
