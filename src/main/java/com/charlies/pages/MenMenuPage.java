package com.charlies.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.charlies.keywords.*;
import com.charlies.waits.*;

public class MenMenuPage {
	
	
	@FindBy(css="div.desktop-navLink a[href^=\"/shop/men\"]")
	public WebElement mensOption;
	
	@FindBy(css="a[href^=\"/men-casual-shirts\"]")
	public WebElement shirtOption;
	
	
	@FindBy(css="h4.product-product")
	public List<WebElement> productNames;
	
	@FindBy(css="div.product-ratingsContainer+a[href*=\"shirts/roadster/roadster-men-maroon--navy-blue-checked-pure-cotton-casual-sustainable-shirt/9951411/buy\"]")
	public WebElement finalProduct;
	
	@FindBy(xpath="//p[contains(text(),\"42\")]")
	public WebElement size;
	

	private By productName = By.cssSelector("h4.product-product");
	
	@FindBy(xpath="//div[contains(text(),'ADD TO BAG')]")
	public WebElement addToBag;
	
	@FindBy(xpath="//span[contains(text(),'GO TO BAG')]")
	public WebElement goToBag;
	
	@FindBy(css="a.itemContainer-base-itemLink")
	public WebElement addedCartProduct;
	
	public MenMenuPage() {
		PageFactory.initElements(keywords.getDriver(), this);
	}
	
	public void mouseHoverTo() {
		keywords keyword = new keywords();
		keyword.getMouseHover(mensOption);
	}
	
	public void clickOnProducts(WebElement ele) {
		ele.click();

	}
	public String getLoginUrl() {
		WaitFor.numberOfElementToBeMoreThan(productName, 1);
		keywords keyword = new keywords();
		String url =keyword.getDriver().getCurrentUrl();
		return url;

	}
	public void verifyURL(String expected_url) {
		String Actualurl=getLoginUrl();
		System.out.println("Actual URL is :" + Actualurl );
		Assert.assertEquals(Actualurl, expected_url);
		System.out.println("Expected and Actual URL is matching" );
	}
	public List<String> getProductNames() {
		keywords keyword = new keywords();
	return keyword.getTexts(productNames);
}
	
	/**
	 * public List<String> verifyProductNamesContains() {
		List<String> pronames=getProductNames();
		for(String shirtname:pronames) 
		{
			if(shirtname.contains("Men Casual Shirt")) 
			{
				finalProduct.click();
			}
			
		}
	 * @return
	 * @throws InterruptedException 
	 */
	 public void selectSize(WebElement size) throws InterruptedException {
		 Thread.sleep(3000);
		 size.click();
		 

	}
	 
	 public void switchToWindow() throws InterruptedException {
		 keywords keyword = new keywords();
		 keyword.getWindowHandle();
		
	} 
	 
	 public String getTextOfAddedCartProduct() {
		 keywords keyword = new keywords();
		 return keyword.getText(addedCartProduct);

	}
	 
	 public void verifyAddProductContains() {
		 String Actual_text =getTextOfAddedCartProduct();
		 String Expected_text = finalProduct.getText();
		 Assert.assertEquals(Actual_text, Expected_text);

	}
	 
}

