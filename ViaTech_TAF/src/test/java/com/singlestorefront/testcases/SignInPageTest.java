package com.singlestorefront.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.singlestorefront.actiondriver.Action;
import com.singlestorefront.base.BaseClass;
import com.singlestorefront.pageobjects.HomePage;
import com.singlestorefront.pageobjects.SignInPage;

public class SignInPageTest extends BaseClass {
	
	SignInPage signinpage;
	HomePage homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke", "Regression"})
	public void launchbrowser(String browser) {
		launchApp(browser);
		signinpage = new SignInPage();
	}
	
	@AfterMethod(groups= {"Smoke", "Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(priority=1)
	public void verifyLogoTest() {
		boolean result = signinpage.verifyLogo();
		Assert.assertTrue(result);
	}
	
	@Test(priority=2)
	public void loginTest() {
		homepage = signinpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String result = Action.getCurrentURL(getDriver());
		Assert.assertEquals(result, prop.getProperty("homepageurl"));
	}

}
