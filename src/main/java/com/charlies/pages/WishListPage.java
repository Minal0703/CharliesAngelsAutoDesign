package com.charlies.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.charlies.keywords.*;

public class WishListPage {
	
Logger LOG=Logger.getLogger(WishListPage.class);
	@FindBy(css="div.wishlistLogin-info")
	public WebElement infoOnWishList;
	
	@FindBy(css="a.wishlistLogin-button")
	public WebElement wishListLoginButton;
	
	public WishListPage() {
		PageFactory.initElements(keywords.getDriver(), this);
	}

	public String getWishListInfoWithOutLogin() {
		return infoOnWishList.getText();
	}
	
	public void verifyIfWishListContainsText(String expected_text) {
		String text =getWishListInfoWithOutLogin();
		Assert.assertEquals(text, expected_text);
		
	}
	
	public void clickOnLogin(WebElement login) {
			login.click();
			LOG.info("Logged in");
	}
}
