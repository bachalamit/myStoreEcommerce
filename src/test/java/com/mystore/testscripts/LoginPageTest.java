package com.mystore.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass{
	
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
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke", "Sanity"})
	public void loginTest(String uname, String pwd) {
		Log.startTestCase("LoginPageTest");
		indexPage = new IndexPage();
		loginpage = indexPage.clickSignIn();
		Log.info("Enter Username and Password");
		//homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginpage.login(uname, pwd);
		
		String actualURL = homePage.getURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login Test Successful");
		Log.endTestCase("LoginPageTest");
		
	}
	
}
