package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass{
	
	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	WebElement confirmOrder;
	
	public OrderSummaryPage()
	{
		PageFactory.initElements(getDriver(), this);
	}

	public OrderConfirmationPage clickOnConfirm()
	{
		Action.click(getDriver(), confirmOrder);
		return new OrderConfirmationPage();
	}


}
