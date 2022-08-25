package com.singlestorefront.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.singlestorefront.actiondriver.Action;
import com.singlestorefront.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath = "//li[@class=\"submenu hideadminmenu\"]")
	private WebElement Item;
	
	@FindBy(xpath = "//a[@class=\"btn btn-primary\"]")
	private WebElement okBtn;
	
	@FindBy(xpath = "//li[@id=\"ctl00_uclSiteTopMenu_liItemManagement\"]")
	private WebElement itemManagement;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ItemManagement moveToItem() throws Exception {
		Action.fluentWait(getDriver(), okBtn, 30);
		Action.simpleClick(okBtn);
		Action.fluentWait(getDriver(), Item, 30);
		Action.mouseOverElement(getDriver(), Item);
		Action.click(Item);
		Action.fluentWait(getDriver(), itemManagement, 20);
		Action.click(itemManagement);
		//Thread.sleep(30);
		return new ItemManagement();
	}

}
