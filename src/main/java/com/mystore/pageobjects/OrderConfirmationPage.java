package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
	@FindBy(xpath = "//p/strong[text()='Your order on My Store is complete.']")
	WebElement confirmmsg;
	
	public OrderConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmmsg()
	{
	
		String getconfirmmsg =confirmmsg.getText();
		return getconfirmmsg;
	}


}
