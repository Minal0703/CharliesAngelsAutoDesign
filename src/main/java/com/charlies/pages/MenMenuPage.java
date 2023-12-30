package com.charlies.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.charlies.keywords.*;
import com.charlies.waits.*;

public class MenMenuPage {
	
	
	Logger LOG = Logger.getLogger(MenMenuPage.class);
	
	@FindBy(css="h4.product-product")
	public List<WebElement> productNames;
	
	@FindBy(css="div.product-ratingsContainer+a[href*=\"shirts/roadster/roadster-men-maroon--navy-blue-checked-pure-cotton-casual-sustainable-shirt/9951411/buy\"]")
	public WebElement finalProduct;
	
	@FindBy(xpath="//p[contains(text(),'42')]")
	public WebElement size;
	
	private By shirtsize = By.xpath("//p[contains(text(),'42')]");

	private By productName = By.cssSelector("h4.product-product");
	
	@FindBy(xpath="//div[contains(text(),'ADD TO BAG')]")
	public WebElement addToBag;
	
	@FindBy(xpath="//span[contains(text(),'GO TO BAG')]")
	public WebElement goToBag;
	
	@FindBy(css="a.itemContainer-base-itemLink")
	public WebElement addedCartProduct;
	
	
	@FindBy(css="ul.breadcrumbs-list")
	public WebElement clothingbreadcrumbs;
	
	public MenMenuPage() {
		PageFactory.initElements(keywords.getDriver(), this);
	}
	
	public String getLoginUrl() {
		WaitFor.numberOfElementToBeMoreThan(productName, 1);
		keywords keyword = new keywords();
		String url =keyword.getDriver().getCurrentUrl();
		return url;

	}
	public void verifyURL(String expected_url) {
		String Actualurl=getLoginUrl();
		Assert.assertEquals(Actualurl, expected_url);
		LOG.info("Expected and Actual URL is matching" );
	}
	public List<String> getProductNames() {
		keywords keyword = new keywords();
	return keyword.getTexts(productNames);
}
	
	public void clickOnProducts(WebElement ele) throws InterruptedException  {
		Thread.sleep(3000);
		ele.click();

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
	 public void selectSize(WebElement size) throws InterruptedException{
		Thread.sleep(5000);
		size.click();
		 

	}
	 
	 public void switchToWindow(){
		 keywords keyword = new keywords();
		 keyword.getWindowHandle();
		 
	} 
	 
	 public String getTextOfAddedCartProduct() {
		 keywords keyword = new keywords();
		 String Actual_text= keyword.getText(addedCartProduct);
		 return Actual_text;
	}
	 
	 public void verifyAddProductContains(){
		 String Actual_text =getTextOfAddedCartProduct();
		 Assert.assertEquals(Actual_text, "Men Maroon & Navy Blue Checked Pure Cotton Casual Sustainable Shirt");

	 }
	 
	 
	 public String getTextOfBreadCrumbs() {
		 return clothingbreadcrumbs.getText();
	}
	 
	 public void verifyTextContains() {
		 String expected_text =getTextOfBreadCrumbs();
		 Assert.assertTrue(expected_text.contains("Clothing"));

	}
}

