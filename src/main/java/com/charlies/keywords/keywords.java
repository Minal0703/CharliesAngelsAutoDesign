package com.charlies.keywords;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.charlies.error.*;

public class keywords {
	
	private static final Logger LOG = Logger.getLogger(keywords.class);
	
	private static RemoteWebDriver driver= null; 
	public  static JavascriptExecutor js = null; 
	public static ChromeOptions chro_options = null;
	public static FirefoxOptions Fire_options = null;
	public static EdgeOptions Edge_options = null;
	
    /*this method returns driver instance but make sure to call openBrowser() 
    method first before calling getDriver method to intialize driver instance **/
	public static RemoteWebDriver getDriver() {
		return driver;
	}
	
	public void openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome"))
		{	
			chro_options = new ChromeOptions();
			driver = new ChromeDriver(chro_options);
			chro_options.addArguments("--disable-notifications--");
			LOG.info("opening chrome browser");
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			Fire_options = new FirefoxOptions();
			driver = new FirefoxDriver(Fire_options);
			Fire_options.addArguments("--disable-notifications--");
			LOG.info("opening firefox browser");
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			Edge_options= new EdgeOptions();
			driver = new EdgeDriver(Edge_options);
			Edge_options.addArguments("--disable-notifications--");
			LOG.info("opening Edge browser");
		}
		else 
		{
			throw new InvalidBrowserError(browserName); 
		}	
	}
		
	public void openUrl(String url) 
		{
			driver.get(url);
			LOG.info("Launching url");
		}
		
	 public void closeBrowser() {
		 driver.close();
	 }
	 
	 public void quitAllWindows() {
		 driver.quit();
	 }
	 
	 public WebElement getWebElement(String locatorType, String locatorValue) {
		 if(locatorType.equalsIgnoreCase("id")){
			return driver.findElement(By.id(locatorValue));
		 }else if(locatorType.equalsIgnoreCase("xpath")){
			 return driver.findElement(By.xpath(locatorValue));
		 }else if(locatorType.equalsIgnoreCase("name")){
			 return driver.findElement(By.name(locatorValue));
		 }else if(locatorType.equalsIgnoreCase("tagName")){
			 return driver.findElement(By.tagName(locatorValue));
		 }else if(locatorType.equalsIgnoreCase("classname")){
			 return driver.findElement(By.className(locatorValue));
		 }else if(locatorType.equalsIgnoreCase("linkText")){
			 return driver.findElement(By.linkText(locatorValue));
		 }else if(locatorType.equalsIgnoreCase("Partial linkText")){
			 return driver.findElement(By.partialLinkText(locatorValue));
		 }else if(locatorType.equalsIgnoreCase("css selectors")){
			 return driver.findElement(By.cssSelector(locatorValue));
	}
		 return null;
	  }
	 
	 public void clickOn(String locatorType, String locatorValue) {
		 getWebElement(locatorType,locatorValue).click();
	}
	 
	 public void SendKeys(String locatorType, String locatorValue,CharSequence... text) {
		 getWebElement(locatorType,locatorValue).sendKeys(text);
	}

	 public List<WebElement> getWebElements(String locatorType,String locatorValue) {
		 if(locatorType.equalsIgnoreCase("id")){
				return driver.findElements(By.id(locatorValue));
			 }else if(locatorType.equalsIgnoreCase("xpath")){
				 return driver.findElements(By.xpath(locatorValue));
			 }else if(locatorType.equalsIgnoreCase("name")){
				 return driver.findElements(By.name(locatorValue));
			 }else if(locatorType.equalsIgnoreCase("tagName")){
				 return driver.findElements(By.tagName(locatorValue));
			 }else if(locatorType.equalsIgnoreCase("classname")){
				 return driver.findElements(By.className(locatorValue));
			 }else if(locatorType.equalsIgnoreCase("linkText")){
				 return driver.findElements(By.linkText(locatorValue));
			 }else if(locatorType.equalsIgnoreCase("Partial linkText")){
				 return driver.findElements(By.partialLinkText(locatorValue));
			 }else if(locatorType.equalsIgnoreCase("css selectors")){
				 return driver.findElements(By.cssSelector(locatorValue));
		}
			 return null;
		  }
		 
	 public List<String>getTexts(String locatorType,String locatorValue) {
		 List<String> texts = new ArrayList<String>();
		 List<WebElement>elements = new ArrayList<WebElement>();
		 elements = getWebElements(locatorType,locatorValue);

		 for(WebElement ele:elements)
		 {
			 texts.add(ele.getText());
		 }
		 return texts;

	}


	public void maximizeWindow() {
		driver.manage().window().maximize();
		
	}

	public List<String> getTexts(List<WebElement> items) {
		List<String> texts = new ArrayList<String>();
		for(WebElement item:items) 
		{
				texts.add(item.getText());
		}
		return texts;
		
	}
	
	public void getMouseHover(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().perform();
	}
	
	 public void scrollDown() {
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", ""); 

	}
	 public List<String> getColorName(List<WebElement> items) {
			List<String> colors = new ArrayList<String>();
			for(WebElement item:items) 
			{
				colors.add(item.getCssValue("Color"));
			}
			return colors;
}
 
	 public void getWindowHandle()  {
		 String parent_window = driver.getWindowHandle();
		 Set <String>child_windows =driver.getWindowHandles();
		 Iterator <String>itr= child_windows.iterator();
		 while(itr.hasNext()) 
		 {
			 
			 	String child_window= itr.next();
			 	if(!parent_window.equalsIgnoreCase(child_window)) 
			 	{
			 		LOG.info(child_window);
			 		driver.switchTo().window(child_window);
			 		
			 	}
		 
		 }
		 
}
	 public String getText(WebElement ele)
	 {
		 return ele.getText();
	 }

}
