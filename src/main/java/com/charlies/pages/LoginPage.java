package com.charlies.pages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.charlies.keywords.*;

public class LoginPage {
	
	
	Logger LOG = Logger.getLogger(LoginPage.class);
	
	@FindBy(css="a.desktop-linkButton")
	public WebElement loginButton;
	
	@FindBy(css="span.mobileNumberPlacholder")
	public WebElement mobileNumField;
	
	@FindBy(css="//span[style*='color']")
	public WebElement asterikSign;
	
	public LoginPage() {
		PageFactory.initElements(keywords.getDriver(), this);
	}
	
	public void clickOnLoginButton(WebElement login) {
		login.click();
	}
	
	public String getText() {
		String text= mobileNumField.getText();
		return text;
	
	}
	public void verifyTextContainsAsterik(String expectedText) {
			String text =getText();
			SoftAssert softly = new SoftAssert();
			softly.assertTrue(text.contains(expectedText));	
			LOG.info("Mandatory Field Mobile no is marked with red Asterik: " + text);
			
	}
	
	public String getLoginUrl() {
		keywords keyword = new keywords();
		String url =keyword.getDriver().getCurrentUrl();
		return url;

	}
	public void verifyLoginURL(String expected_url) {
		String Actualurl=getLoginUrl();
		Assert.assertEquals(Actualurl, expected_url);
		LOG.info("Expected and Actual URL is matching" );
	}
}
	

