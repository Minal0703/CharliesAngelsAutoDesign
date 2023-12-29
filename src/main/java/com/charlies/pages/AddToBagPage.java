package com.charlies.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.charlies.waits.WaitFor;

public class AddToBagPage {

	Logger LOG = Logger.getLogger(AddToBagPage.class);
	@FindBy(css = "div.pdp-add-to-bag.pdp-button.pdp-flex.pdp-center")
	public WebElement addToBag;

	@FindBy(css = "button.size-buttons-size-button.size-buttons-size-button-default")
	public WebElement mediumSize;

	private By mediumSizeBy = By.cssSelector("button.size-buttons-size-button.size-buttons-size-button-default");

	@FindBy(css = "span.myntraweb-sprite.desktop-iconBag.sprites-headerBag")
	public WebElement bag;

	private By bagBy = By.cssSelector("span.myntraweb-sprite.desktop-iconBag.sprites-headerBag");

	@FindBy(css = "span.desktop-badge.desktop-melon")
	public WebElement bagMessage;

	private By bagMessageBy = By.cssSelector("span.desktop-badge.desktop-melon");

	@FindBy(css = "li label input[value=\"255.0 TO 6391.0\"]")
	public WebElement prizeFilterCheckbox;

	public void selectKurtaSize() {

		if (mediumSize != null && mediumSize.isDisplayed()) {
			WaitFor.waitForelementToBeClickable(mediumSize);
			mediumSize.click();
		}
	}

	public void clickOnAddToBag() {

		if (addToBag != null && addToBag.isDisplayed()) {
			WaitFor.waitForelementToBeClickable(addToBag);
			addToBag.click();
		}

	}

	public String getBagRespondMsg() {
		if (bagMessage != null && bagMessage.isDisplayed()) {
			WaitFor.presenceOfElementToBeLocated(bagMessageBy);
		}
		return bagMessage.getText();
	}

	public void applyPrizeFilter() {
		if (prizeFilterCheckbox != null && prizeFilterCheckbox.isDisplayed()) {
			WaitFor.waitForelementToBeClickable(prizeFilterCheckbox);
		prizeFilterCheckbox.click();}
		LOG.info("Selected");
	}
}
