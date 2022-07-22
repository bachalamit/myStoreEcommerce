package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SerachResultPage extends BaseClass{
	
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	public SerachResultPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable()
	{
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddtoCartPage clickOnProduct()
	{
		Action.click(getDriver(), productResult);
		return new AddtoCartPage();
	}

}
