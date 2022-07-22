package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
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
	public void VerifymyStoreLogo()
	{
		
		Log.startTestCase("myStore Logo");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("myStore Logo");
	}
	
	@Test(groups = "Smoke")
	public void VerifyTitle()
	{
		Log.startTestCase("Verify Title");
		
		indexPage = new IndexPage();
		String actTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
		Log.endTestCase("Title");
		
	}
	
}
