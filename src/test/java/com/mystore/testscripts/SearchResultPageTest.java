package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SerachResultPage;
import com.mystore.utility.Log;

public class SearchResultPageTest extends BaseClass{
	
	IndexPage indexPage;
	SerachResultPage serachResultPage;
	
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
	
	@Test(groups = "Smoke", dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvaliablityTest(String searchproduct)
	{
		Log.startTestCase("Search Result Page");

		indexPage = new IndexPage();
		serachResultPage = indexPage.searchProduct(searchproduct);
		boolean result = serachResultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("Search Result Page");
	}

}
