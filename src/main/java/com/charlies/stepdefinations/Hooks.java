package com.charlies.stepdefinations;


import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.NoSuchSessionException;

import com.charlies.base.*;
import com.charlies.keywords.*;

public class Hooks {
	
	@Before
	public void setUp() {
		keywords keyword = new keywords(); 
		keyword.openBrowser(Config.getBrowserName());
		keyword.openUrl(Config.getAppURL());
		keyword.maximizeWindow();
	}

	/**@After
	public void tierDown() {
		keywords keyword = new keywords();
		try {
		keyword.closeBrowser();
		}catch(NoSuchSessionException e) 
		{
			e.printStackTrace();
		}
	}**/
}