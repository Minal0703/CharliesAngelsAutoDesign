package com.charlies.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.charlies.keywords.*;
import com.charlies.waits.*;


public class HomePage {
	
	
	Logger LOG = Logger.getLogger(HomePage.class);
	
	@FindBy(css ="div.desktop-query>input.desktop-searchBar")
	public WebElement searchComponent;
	
	@FindBy(css="div.desktop-userIconsContainer>span.desktop-userTitle")
	public WebElement userProfile;
	
	@FindBy(xpath="//span[@class=\"myntraweb-sprite desktop-iconWishlist sprites-headerWishlist\"]")
	public WebElement wishListButton;
	
	
	@FindBy(css="div.desktop-navLink a[href^=\"/shop/men\"]")
	public WebElement mensOption;
	
	
	@FindBy(css="a[href^=\"/men-casual-shirts\"]")
	public WebElement shirtOption;
	
	
	public By wishListButton1 = By.xpath("//span[@class=\"myntraweb-sprite desktop-iconWishlist sprites-headerWishlist\"]");
	
	public HomePage() {
		PageFactory.initElements(keywords.getDriver(), this);
	}
	
	//Action or methods to be performed on webelement
	public void enterProductToSearch(CharSequence...productName) {
		searchComponent.sendKeys(productName);
		LOG.info("Entered product to serach"+ productName+"to search");
	}
	
	public void clickOnUserProfile() {
		userProfile.click();

	}
	public void clickOnWishList() {
		WaitFor.presenceOfElementToBeLocated(wishListButton1);
		wishListButton.click();

	}
	public void mouseHoverTo() {
		keywords keyword = new keywords();
		keyword.getMouseHover(mensOption);
	}

	public void clickOnProducts(WebElement ele) {
		WaitFor.waitForelementToBeClickable(ele);
		ele.click();

	}
}
