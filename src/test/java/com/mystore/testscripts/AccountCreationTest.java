package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class AccountCreationTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginpage;
	AccountCreationPage accountCreationPage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser)
	{
		launchApp(browser);
	}
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(groups = "Sanity", dataProvider = "email", dataProviderClass = DataProviders.class)
	public void verifyCreateAccPageTest(String email)
	{
		Log.startTestCase("Account Creation Page");
		
		indexPage = new IndexPage();
		loginpage=indexPage.clickSignIn();
		accountCreationPage = loginpage.createNewAccount(email);
		boolean result = accountCreationPage.validateCreateAccPage();
		Assert.assertTrue(result);
		Log.endTestCase("Account Creation Page");

	}

}
