package com.singlestorefront.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.singlestorefront.actiondriver.Action;
import com.singlestorefront.base.BaseClass;

public class SignInPage extends BaseClass {
	
	@FindBy(xpath = "//img[@alt=\"Banner-Logo\"]")
	private WebElement logo;
	
	@FindBy(xpath = "//input[@name=\"ctl00$cnpPlaceHolder$UserName\"]")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@name=\"ctl00$cnpPlaceHolder$Password\"]")
	private WebElement password;
	
	@FindBy(xpath = "//input[@name=\"ctl00$cnpPlaceHolder$Login\"]")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//input[@name=\"ctl00$cnpPlaceHolder$btnContinou\"]")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//input[@name=\"ctl00$uclSiteTopMenu$txtSearch\"]")
	private WebElement searchBar;
	
	public SignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyLogo() {
		Action.fluentWait(getDriver(), logo, 10);
		return Action.isDisplayed(getDriver(), logo);
	}
	
	public HomePage login(String uname, String pwd) {
		Action.fluentWait(getDriver(), logo, 10);
		Action.fluentWait(getDriver(), userName, 10);
		Action.click(userName);
		Action.type(userName, uname);
		Action.fluentWait(getDriver(), password, 10);
		Action.type(password, pwd);
		Action.fluentWait(getDriver(), signInBtn, 10);
		Action.click(signInBtn);
		Action.fluentWait(getDriver(), continueBtn, 5);
		boolean x = Action.isDisplayed(getDriver(), continueBtn);
		if(x) {
			Action.click(continueBtn);
		}
		Action.fluentWait(getDriver(), searchBar, 60);
		return new HomePage();
	}

}
