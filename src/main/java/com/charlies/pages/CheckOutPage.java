package com.charlies.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.charlies.keywords.keywords;
import com.charlies.waits.WaitFor;

public class CheckOutPage {
	
	Logger LOG = Logger.getLogger(CheckOutPage.class);
	
	@FindBy(css="rect.bulkActionStrip-inActiveIcon")
	public WebElement itemSelectionCheckBox;
	
	
	@FindBy(xpath="(//button[contains(text(),'REMOVE')])[1]")
	public WebElement removeOption;
	
	@FindBy(xpath="(//button[contains(text(),'REMOVE')])[2]")
	public WebElement removeOption2;
	
	
	@FindBy(css="div.itemComponents-base-selectionIconContainer")
	public WebElement containerMessage;

	
	@FindBy(css="div.notifyText")
	public WebElement endCartMessage;
	
	private By notifyText = By.cssSelector("div.notifyText");
	
	//private By removeOption1 = By.xpath("//button[contains(text(),\"REMOVE\")]");
	
	public CheckOutPage() {
		PageFactory.initElements(keywords.getDriver(), this);
	}
	
	
	public void clickOnItemCheckBox() {
		itemSelectionCheckBox.click();
	}
	
	public void clickOnRemove(WebElement ele){
		WaitFor.waitForelementToBeClickable(ele);
		ele.click();

	}
	
	public void clickOnCartMessage() {
		WaitFor.waitForelementToBeClickable(containerMessage);
		containerMessage.click();

	}
	
	public void verifyCartMessage() {
		WaitFor.presenceOfElementToBeLocated(notifyText);
		String actual_text=endCartMessage.getText();
		LOG.info(actual_text);
		Assert.assertEquals(actual_text, "1 item removed from bag.");


	}
}
