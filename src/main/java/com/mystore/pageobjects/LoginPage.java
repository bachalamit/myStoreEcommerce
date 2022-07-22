package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(id = "email")
	WebElement userName;
	
	@FindBy(id = "passwd")
	WebElement password;
	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id = "email_create")
	WebElement emailAccCreate;
	
	@FindBy(name = "SubmitCreate")
	WebElement createNewAccbtn;
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	public HomePage login(String uname, String pwd)
	{
		Action.type(userName, uname);
		Action.type(password, pwd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname, String pwd)
	{
		Action.type(userName, uname);
		Action.type(password, pwd);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();
	}
	public AccountCreationPage createNewAccount(String NewEmail)
	{
		Action.type(emailAccCreate, NewEmail);
		Action.click(getDriver(), createNewAccbtn);
		return new AccountCreationPage();
	}
	
}
