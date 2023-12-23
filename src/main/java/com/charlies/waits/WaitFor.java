package com.charlies.waits;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.charlies.keywords.*;

public class WaitFor {
	
	private static FluentWait wait = null;
	static {
		wait = new FluentWait<WebDriver>(keywords.getDriver());
		wait.pollingEvery(Duration.ofMillis(5000));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		
	}
	
	public static void numberOfElementToBeMoreThan(String locatorType,String locatorValue,int count) {
		By element = null;
		if(locatorType.equalsIgnoreCase("id")){
			 element =By.id(locatorValue);
		 }else if(locatorType.equalsIgnoreCase("xpath")){
			 element =By.xpath(locatorValue);
		 }else if(locatorType.equalsIgnoreCase("name")){
			 element =By.name(locatorValue);
		 }else if(locatorType.equalsIgnoreCase("tagName")){
			 element =By.tagName(locatorValue);
		 }else if(locatorType.equalsIgnoreCase("classname")){
			 element =By.className(locatorValue);
		 }else if(locatorType.equalsIgnoreCase("linkText")){
			 element =By.linkText(locatorValue);
		 }else if(locatorType.equalsIgnoreCase("Partial linkText")){
			 element =By.partialLinkText(locatorValue);
		 }else if(locatorType.equalsIgnoreCase("css selectors")){
			 element =By.cssSelector(locatorValue);
	}
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(element, count));

}
	
	
	public static void presenceOfElementToBeLocated(By ele ) {
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));

}
        public static void waitForstaleElementReferenceException(WebElement ele) {
        	wait.until(ExpectedConditions.stalenessOf(ele));


		}
        
        public static void waitForelementToBeClickable(WebElement ele) {
        	wait.until(ExpectedConditions.elementToBeClickable(ele));


		}


		public static void numberOfElementToBeMoreThan(By dressName1, int count) {
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(dressName1, count));
			
		}
}


