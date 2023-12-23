package com.charlies.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.charlies.keywords.keywords;
import com.charlies.waits.WaitFor;

public class CheckOutPage {
	
	
	@FindBy(css="rect.bulkActionStrip-inActiveIcon")
	public WebElement itemSelectionCheckBox;
	
	
	@FindBy(xpath="//button[contains(text(),\"REMOVE\")]")
	public WebElement removeOption;
	
	private By removeOption1 = By.xpath("//button[contains(text(),\"REMOVE\")]");
	
	public CheckOutPage() {
		PageFactory.initElements(keywords.getDriver(), this);
	}
	
	
	public void clickOnItemCheckBox() {
		itemSelectionCheckBox.click();
	}
	
	public void clickOnRemove() {
		WaitFor.presenceOfElementToBeLocated(removeOption1);
		removeOption.click();

	}
	
}
