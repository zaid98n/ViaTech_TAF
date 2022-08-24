package com.singlestorefront.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.singlestorefront.actiondriver.Action;
import com.singlestorefront.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath = "(//a[@class=\"has-submenu\"])[7]")
	private WebElement Item;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void moveToItem() throws Exception {
		Action.fluentWait(getDriver(), Item, 30);
		Action.mouseOverElement(getDriver(), Item);
		Action.click(Item);
		Thread.sleep(30);
	}

}
