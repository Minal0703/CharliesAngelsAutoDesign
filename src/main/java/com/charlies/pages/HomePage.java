package com.jarvis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jarvis.keywordFramework.keywords;
import com.jarvis.waits.WaitFor;


public class HomePage {
	
	//WebElements
	@FindBy(css ="div.desktop-query>input.desktop-searchBar")
	public WebElement searchComponent;
	
	@FindBy(css="div.desktop-userIconsContainer>span.desktop-userTitle")
	public WebElement userProfile;
	
	@FindBy(xpath="//span[@class=\"myntraweb-sprite desktop-iconWishlist sprites-headerWishlist\"]")
	public WebElement wishListButton;
	
	
	public By wishListButton1 = By.xpath("//span[@class=\"myntraweb-sprite desktop-iconWishlist sprites-headerWishlist\"]");
	
	public HomePage() {
		PageFactory.initElements(keywords.getDriver(), this);
	}
	
	//Action or methods to be performed on webelement
	public void enterProductToSearch(CharSequence...productName) {
		searchComponent.sendKeys(productName);

	}
	
	public void clickOnUserProfile() {
		userProfile.click();

	}
	public void clickOnWishList() {
		WaitFor.presenceOfElementToBeLocated(wishListButton1);
		wishListButton.click();

	}

}
