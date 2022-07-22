package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SerachResultPage;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClass{
	IndexPage indexPage;
	SerachResultPage serachResultPage;
	AddtoCartPage addtoCartPage;
	OrderPage orderPage;
	LoginPage loginpage;
	
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
	
	
	@Test(groups = "Regression", dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productname, String qty, String size) throws Exception
	{
		Log.startTestCase("verifyTotalPrice");
		indexPage = new IndexPage();
		serachResultPage = indexPage.searchProduct(productname);
		addtoCartPage = serachResultPage.clickOnProduct();
		addtoCartPage.selectQty(qty);
		addtoCartPage.selectSize(size);
		addtoCartPage.addtocart();
		orderPage = addtoCartPage.clickOnCheckOut();
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice*(Double.parseDouble(qty)))+2;
		
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		loginpage = orderPage.clickOnCheckOut();
		Log.endTestCase("verifyTotalPrice");
		
	}

}
