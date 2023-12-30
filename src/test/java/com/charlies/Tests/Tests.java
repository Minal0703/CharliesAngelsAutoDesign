package com.charlies.Tests;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.charlies.keywords.*;
import com.charlies.base.Locator;
import com.charlies.base.TestBase;
import com.charlies.pages.*;




public class Tests extends TestBase{
	
	
	@Test(enabled=false)
	public void FirstTest() {
		RemoteWebDriver  driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("---)
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder*=\"Search for\"]")).sendKeys("Levis",Keys.ENTER);
		List<WebElement> productTitles = driver.findElements(By.cssSelector("h3.product-brand"));
		SoftAssert softly = new SoftAssert();
		for(WebElement productTitle:productTitles ) 
		{
			String Text = productTitle.getText();
			System.out.println("Checking LevisTitle"+ Text);
			softly.assertTrue(Text.contains("Levis"));
		}

		softly.assertAll();
		driver.quit();
	}
	
	@Test(enabled=false)
	public void testWithKeyword() {
		keywords keyword = new keywords();
		keyword.SendKeys("css selectors", Locator.searchComponent, "Levis",Keys.ENTER);
		List<String>productTitles =keyword.getTexts("css selectors", Locator.ProductTitle);
		SoftAssert softly = new SoftAssert();
		for(String title:productTitles)
		{
			softly.assertTrue(title.contains("Levis"));
		}
		softly.assertAll();
	}
	
	@Test
	public void usingPageObjectModel() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Levis",Keys.ENTER);
		SearchResultPage resultpage = new SearchResultPage();
		resultpage.verifyProductTitlesContains("Levis");
	}
	
	@Test(enabled=false)
	public void verifyLoginFieldIsMarkedWithAsterik() {
		HomePage homepage = new HomePage();
		homepage.clickOnUserProfile();
		LoginPage loginpage = new LoginPage();
		loginpage.clickOnLoginButton(loginpage.loginButton);
		loginpage.verifyTextContainsAsterik("*");
		
	}
	
	@Test(enabled=false)
	public void verifyUserIsNotAbleToViewWishListItemsWithOutLogin(){
		HomePage homepage = new HomePage();
		homepage.clickOnWishList();
		WishListPage wishlistpg = new WishListPage();
		wishlistpg.verifyIfWishListContainsText("Login to view items in your wishlist.");

	}
	
	@Test(enabled=false)
	public void verifyUserCanNavigateToLoginPageFromWishListPage() {
		HomePage homepage = new HomePage();
		homepage.clickOnWishList();
		WishListPage wishlistpg = new WishListPage();
		wishlistpg.clickOnLogin(wishlistpg.wishListLoginButton);
		LoginPage loginpage = new LoginPage();
		loginpage.verifyLoginURL("https://www.myntra.com/login?referer=https://www.myntra.com/wishlist");
	}
	
	@Test(enabled=false)
	public void verifyUserIsAbleToSortProductByHighToLow() throws InterruptedException, InvocationTargetException {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Mango",Keys.ENTER);
		SearchResultPage resultpage = new SearchResultPage();
		Thread.sleep(3000);
		resultpage.verifyProductTitlesContains("MANGO");
		resultpage.hoverOnSortByDropDown();
		resultpage.clickOnHighToLow();
		resultpage.verifyProductPriceBetweenHighToLow();
	}
	@Test(enabled=false)
	public void verifyUserIsAbleToSortProductByLowToHigh() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Mango",Keys.ENTER);
		SearchResultPage resultpage = new SearchResultPage();
		Thread.sleep(3000);
		resultpage.verifyProductTitlesContains("MANGO");
		resultpage.hoverOnSortByDropDown();
		resultpage.clickOnLowToHigh();
		resultpage.verifyProductPriceBetweenLowToHigh();
	}
	
	@Test(enabled=false)
	public void verifyDressesFilterInLeftSideMenuForParticularProduct() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Mango",Keys.ENTER);
		SearchResultPage resultpage = new SearchResultPage();
		resultpage.selectCheckBox(resultpage.dressFilter);
		Thread.sleep(5000);
		resultpage.verifyDressNameContains("Dress");
		System.out.println("Mango dresses found");
	}
	
	
	@Test(enabled=false)
	public void verifyUserIsAbleToFilterDressesOnBasisOfColour() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Mango",Keys.ENTER);
		SearchResultPage resultpage = new SearchResultPage();
		resultpage.selectCheckBox(resultpage.dressFilter);
		resultpage.selectCheckBox(resultpage.colorFilter);
		resultpage.verifyURL("https://www.myntra.com/mango?f=Categories%3ADresses%3A%3AColor%3ABlack_36454f&rawQuery=Mango");

	}
	
	@Test(enabled=false)
	public void verifyUserCanNavigateToMensClothingFromTopMenu() {
		HomePage homepage = new HomePage();
		homepage.mouseHoverTo();
		homepage.clickOnProducts(homepage.shirtOption);
		
	}
	@Test(enabled=false)
	public void verifyUserCanAddProductToBag() throws InterruptedException {
		HomePage homepage = new HomePage();
		MenMenuPage menupage = new MenMenuPage();
		homepage.mouseHoverTo();
		homepage.clickOnProducts(homepage.shirtOption);
		menupage.clickOnProducts(menupage.finalProduct);
		Thread.sleep(5000);
		menupage.switchToWindow();
		menupage.selectSize(menupage.size);
		menupage.clickOnProducts(menupage.addToBag);
		Thread.sleep(3000);
		menupage.clickOnProducts(menupage.goToBag);
		menupage.verifyAddProductContains();
	}
	
	@Test
	public void verifyUserIsAbleToRemoveProductFromBag() throws InterruptedException {
		HomePage homepage = new HomePage();
		MenMenuPage menupage = new MenMenuPage();
		CheckOutPage checkpage = new CheckOutPage();
		homepage.mouseHoverTo();
		homepage.clickOnProducts(homepage.shirtOption);
		menupage.clickOnProducts(menupage.finalProduct);
		Thread.sleep(5000);
		menupage.switchToWindow();
		menupage.selectSize(menupage.size);
		menupage.clickOnProducts(menupage.addToBag);
		Thread.sleep(5000);
		menupage.clickOnProducts(menupage.goToBag);
		Thread.sleep(3000);
		checkpage.clickOnRemove(checkpage.removeOption);

	}
		
}
	

