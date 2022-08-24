package com.singlestorefront.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.singlestorefront.base.BaseClass;
import com.singlestorefront.pageobjects.HomePage;
import com.singlestorefront.pageobjects.SignInPage;

public class HomePageTest extends BaseClass {
	
	SignInPage signinpage;
	HomePage homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Regression"})
	public void launchbrowser(String browser) {
		launchApp(browser);
		signinpage = new SignInPage();
		homepage = new HomePage();
		homepage = signinpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
//	@AfterMethod(groups= {"Smoke", "Regression"})
//	public void teardown() {
//		getDriver().quit();
//	}
	
	@Test
	public void itempage() throws Exception {
		homepage.moveToItem();
	}

}
