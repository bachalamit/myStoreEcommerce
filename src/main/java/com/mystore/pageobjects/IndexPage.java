package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@alt='My Store']")
	WebElement myStoreLogo;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchBox;
	
	@FindBy(name = "submit_search")
	WebElement searchbtn;
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickSignIn()
	{
		Action.fluentWait(signInBtn, 10);
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle()
	{
		String myStoreTitle = getDriver().getTitle();
		return myStoreTitle;
	}
	
	
	public SerachResultPage searchProduct(String productName)
	{
		Action.type(searchBox, productName);
		Action.click(getDriver(), searchbtn);
		return new SerachResultPage();
	}

	
	

}
