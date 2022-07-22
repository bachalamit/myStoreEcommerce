package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass{
	
	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtocheckout;
	
	public AddressPage()
	{
		PageFactory.initElements(getDriver(), this);
	}

	public ShippingPage checkout()
	{
		Action.click(getDriver(), proceedtocheckout);
		return new ShippingPage();
	}


}
