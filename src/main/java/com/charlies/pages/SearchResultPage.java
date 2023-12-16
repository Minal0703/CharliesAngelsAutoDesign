package com.jarvis.pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jarvis.keywordFramework.keywords;
import com.jarvis.waits.WaitFor;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SearchResultPage {
	
	@FindBy(css="h3.product-brand")
	public List<WebElement> productTitle;
	
	@FindBy(css="div.sort-sortBy")
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
		System.out.println(titles);
		SoftAssert softly = new SoftAssert();
		for(String title:titles)
		{	
			System.out.println(title);
			softly.assertTrue(title.contains(expectedText));
		}
		softly.assertAll();
}
	
	public void hoverOnSortByDropDown() {
		keywords keyword = new keywords();
		keyword.getMouseHover(sortByDropDown);
	}
	
	public void clickOnHighToLow(){
		//WaitFor.presenceOfElementToBeLocated(productPrice1);
		WaitFor.waitForelementToBeClickable(highToLow);
		highToLow.click();

	}
	
	public void clickOnLowToHigh(){
		//WaitFor.presenceOfElementToBeLocated(productPrice1);
		WaitFor.waitForelementToBeClickable(LowToHigh);
		LowToHigh.click();

	}
	
	public void selectCheckBox(WebElement ele) throws InterruptedException {
		Thread.sleep(5000);
		keywords keyword = new keywords();
		keyword.getMouseHover(ele);
		
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
		System.out.println(proprices.size());
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
	         System.out.println("Price of product is:" + number);
	         break;
			}
			softly.assertTrue(number>=8000 && number<=18000);
			System.out.println("Products are sorted on the basis of high to low");
		}
		softly.assertAll();
	   }
	
	public void verifyProductPriceBetweenLowToHigh() {
		List<String> proprices =getDiscountedPrice();
		System.out.println(proprices.size());
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
	         System.out.println("Price of product is:" + number);
	         break;
			}
			softly.assertTrue(number>=300 && number<=500);
			System.out.println("Products are sorted on the basis of high to low");
		}
		softly.assertAll();
	   }
			
	public List<String> getDressName() {
		WaitFor.numberOfElementToBeMoreThan(dressName1,1);
		keywords keyword = new keywords();
		return keyword.getTexts(dressName);
	}
	
	public void verifyDressNameContains(String expectedText) {
		List<String> titles =getDressName();
		System.out.println(titles);
		SoftAssert softly = new SoftAssert();
		for(String title:titles)
		{	
			System.out.println(title);
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
			System.out.println(color);
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
		System.out.println("Actual URL is :" + Actualurl );
		Assert.assertEquals(Actualurl, expected_url);
		System.out.println("Expected and Actual URL is matching" );
	}
}
	


