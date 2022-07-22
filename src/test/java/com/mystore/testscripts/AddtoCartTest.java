package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SerachResultPage;
import com.mystore.utility.Log;

public class AddtoCartTest extends BaseClass{
	IndexPage indexPage;
	SerachResultPage serachResultPage;
	AddtoCartPage addtoCartPage;
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
	
	@Test(groups = {"Regression", "Sanity"})
	public void addtoCartTest() throws Exception
	{
		Log.startTestCase("Add To Cart");
		indexPage = new IndexPage();
		serachResultPage = indexPage.searchProduct("t-shirt");
		addtoCartPage = serachResultPage.clickOnProduct();
		addtoCartPage.selectQty("3");
		addtoCartPage.selectSize("M");
		addtoCartPage.addtocart();
		boolean result = addtoCartPage.validateAddToCart();
		Assert.assertTrue(result);
		
	//	addtoCartPage.clickOnCheckOut();
		
		Log.endTestCase("Add To Cart");
		

		
	}

}
