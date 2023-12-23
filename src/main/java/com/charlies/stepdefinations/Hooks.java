package com.charlies.stepdefinations;


import io.cucumber.java.After;
import io.cucumber.java.Before;
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

}