package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginpage;
	HomePage homePage;
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

	@Test(groups = "Smoke")
	public void wishListTest()
	{
		indexPage = new IndexPage();
		loginpage=indexPage.clickSignIn();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateWishList();
		Assert.assertTrue(result);
		
	}
	@Test(groups = "Smoke")
	public void orderHistoryTest()
	{
		indexPage = new IndexPage();
		loginpage=indexPage.clickSignIn();
		homePage=loginpage.login(prop.getProperty("username"),prop.getProperty("password")); 
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
	}
}
