package com.jarvis.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.jarvis.keywordFramework.*;

public class TestBase {
	
	keywords keyword = new keywords(); 
	
	@BeforeMethod
	public void setUp() throws Exception {
		keyword.openBrowser(Config.getBrowserName());
		keyword.openUrl(Config.getAppURL());
		keyword.maximizeWindow();
	}
	
	@AfterMethod
	public void teirDown() {
		keyword.closeBrowser();
	}

}
