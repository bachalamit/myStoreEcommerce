package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SerachResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

public class EndToEndTest extends BaseClass{
	IndexPage indexPage;
	SerachResultPage serachResultPage;
	AddtoCartPage addtoCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
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
	@Test(groups = "Regression")
	public void endToEndTest() throws Exception
	{
		Log.startTestCase("End To End");
		indexPage = new IndexPage();
		serachResultPage = indexPage.searchProduct("t-shirt");
		addtoCartPage = serachResultPage.clickOnProduct();
		addtoCartPage.selectQty("3");
		addtoCartPage.selectSize("M");
		addtoCartPage.addtocart();
		orderPage = addtoCartPage.clickOnCheckOut();
		
		
		loginPage = orderPage.clickOnCheckOut();
		addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = addressPage.checkout();
		shippingPage.checkTerms();
		paymentPage = shippingPage.clickonCheckout();
		orderSummaryPage = paymentPage.clickOnBankWire();
		orderConfirmationPage = orderSummaryPage.clickOnConfirm();
		String actualMessage = orderConfirmationPage.validateConfirmmsg();
		String ecpectedMessage = "Your order on My Store is complete.";
		
		Assert.assertEquals(actualMessage, ecpectedMessage);
		
		Log.endTestCase("End To End");
		
	}
}
