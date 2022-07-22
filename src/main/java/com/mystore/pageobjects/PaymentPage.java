package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{
	
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement bankWire;

	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement byCheck;

	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummaryPage clickOnBankWire()
	{
		Action.click(getDriver(), bankWire);
		return new OrderSummaryPage();
	}
	public OrderSummaryPage clickOnByCheck()
	{
		Action.click(getDriver(), byCheck);
		return new OrderSummaryPage();
	}


}
