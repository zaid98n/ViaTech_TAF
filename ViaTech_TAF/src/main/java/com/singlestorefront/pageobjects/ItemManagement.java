package com.singlestorefront.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.singlestorefront.actiondriver.Action;
import com.singlestorefront.base.BaseClass;

public class ItemManagement extends BaseClass {
	
	@FindBy(xpath = "(//input[@value=\"Add Item\"])[1]")
	private WebElement addItem;
	
	@FindBy(xpath = "(//span[@dir=\"ltr\"])[1]")
	private WebElement itemType;
	
	public ItemManagement() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectType() throws Exception {
		Action.fluentWait(getDriver(), addItem, 20);
		Action.click(addItem);
		Action.fluentWait(getDriver(), itemType, 20);
		Action.click(itemType);
		Thread.sleep(10000);
	}
	
	public void Create() throws Exception {
		selectType();
	}

}
