package com.charlies.pages;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.charlies.keywords.*;
import com.charlies.waits.*;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SearchResultPage {
	
	Logger LOG = Logger.getLogger(SearchResultPage.class);
	
	@FindBy(css="span.sprites-search")
	public WebElement glassMagnifier;
	
	@FindBy(css="h3.product-brand")
	public List<WebElement> productTitle;
	
	@FindBy(css="span.sprites-downArrow")
	public WebElement sortByDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Price: High to Low')]")
	public WebElement highToLow;
	
	@FindBy(css="div.product-price")
	public List<WebElement> productPrice;
	
	@FindBy(xpath="//h4[contains(text(),'Virgin Wool Sustainable Coat')]")
	public WebElement singleProd;
	
	private By productPrice1 = By.cssSelector("div.product-price");
	private By dressFilter1 = By.cssSelector("ul.categories-list label input[value*=\\\"Dresses\\\"]");
	
	@FindBy(xpath="//label[contains(text(),'Price: Low to High')]")
	public WebElement LowToHigh;
	
	
	@FindBy(css="span.product-discountedPrice")
	public List<WebElement> discPrice;
	
	
	@FindBy(css="ul.categories-list label input[value*=\"Dresses\"]")
	public WebElement dressFilter;
	
	@FindBy(css="h4.product-product")
	public List<WebElement> dressName;
	
	private By dressName1 = By.cssSelector("h4.product-product");
	
	@FindBy(css="span.image-grid-similarColorsIcon")
	public List<WebElement> colorName;

	@FindBy(css="li.colour-listItem label span[data-colorhex=\"black\"]")
	public WebElement colorFilter;
	
	public SearchResultPage() {
		PageFactory.initElements(keywords.getDriver(), this);
	}
	
	public List<String> getProductTitles() {
		keywords keyword = new keywords();
		return keyword.getTexts(productTitle);
	}
	public void verifyProductTitlesContains(String expectedText) {
		List<String> titles =getProductTitles();
		SoftAssert softly = new SoftAssert();
		for(String title:titles)
		{	
			LOG.info(title);
			softly.assertTrue(title.contains(expectedText));
		}
		softly.assertAll();
}
	
	public void hoverOnSortByDropDown() {
		keywords keyword = new keywords();
		keyword.getMouseHover(sortByDropDown);
	}
	
	public void clickOnHighToLow(){
		WaitFor.waitForelementToBeClickable(highToLow);
		highToLow.click();
		
	}
	public void clickOnLowToHigh() {
		WaitFor.waitForelementToBeClickable(LowToHigh);
		LowToHigh.click();

	}
	
	public void selectCheckBox(WebElement ele){
		keywords keyword = new keywords();
		keyword.getMouseHover(ele);
		
	}
	
	public void clickOnDressFilter() throws InterruptedException {
		Thread.sleep(5000);
		dressFilter.click();

	}
	
	public  List<String> getProductPrice() {
		keywords keyword = new keywords();
		return keyword.getTexts(productPrice);
	}
	
	public List<String> getDiscountedPrice() {
		keywords keyword = new keywords();
		return keyword.getTexts(discPrice);
	}

	
	public void verifyProductPriceBetweenHighToLow() {
		List<String> proprices =getProductPrice();
		SoftAssert softly = new SoftAssert();
		int number = 0;
		for(String proprice:proprices) 
		{
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(proprice);
			while (matcher.find()) {
	         String numberStr = matcher.group();
	         number = Integer.parseInt(numberStr); 
	         break;
			}
			softly.assertTrue(number>=4000 && number<=17000);
			LOG.info("Products are sorted on the basis of high to low");
		}
		softly.assertAll();
	   }
	
	public void verifyProductPriceBetweenLowToHigh() {
		List<String> proprices =getDiscountedPrice();
		SoftAssert softly = new SoftAssert();
		int number = 0;
		for(String proprice:proprices) 
		{
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(proprice);
			while (matcher.find()) {
	         String numberStr = matcher.group();
	         number = Integer.parseInt(numberStr); 
	         //num.add(number);
	         LOG.info("Price of product is:" + number);
	         break;
			}
			softly.assertTrue(number>=300 && number<=1000);
			LOG.info("Products are sorted on the basis of low to high");
		}
		softly.assertAll();
	   }
			
	public List<String> getDressName() {
		keywords keyword = new keywords();
		return keyword.getTexts(dressName);
	}
	
	public void verifyDressNameContains(String expectedText) {
		List<String> titles =getDressName();
		SoftAssert softly = new SoftAssert();
		for(String title:titles)
		{	
			LOG.info(title);
			softly.assertTrue(title.contains(expectedText));
		}
		softly.assertAll();
}
	public List<String> getColourName() {
		keywords keyword = new keywords();
		return keyword.getColorName(dressName);
	}
	
	public void verifyProductColourName() {
		List<String> dresscolours =getColourName();
		SoftAssert softly = new SoftAssert();
		for(String color:dresscolours) 
		{
			LOG.info(color);
			softly.assertTrue(color.contains("black"));
		}

		softly.assertAll();
	}
	
	public String getLoginUrl() {
		WaitFor.numberOfElementToBeMoreThan(dressName1, 1);
		keywords keyword = new keywords();
		String url =keyword.getDriver().getCurrentUrl();
		return url;

	}
	public void verifyURL(String expected_url) {
		String Actualurl=getLoginUrl();
		Assert.assertEquals(Actualurl, expected_url);
		LOG.info("Expected and Actual URL is matching" );
	}
	
	public void clicksOnGlassMagnifier() {
		glassMagnifier.click();
	
	}
}
	


