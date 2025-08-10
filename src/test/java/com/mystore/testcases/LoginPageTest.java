package com.mystore.testcases;

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

public class LoginPageTest extends BaseClass{
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup()
	{
		launchApp();
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown()
	{
		getDriver().quit();
	}
	@Test(groups = "Regression",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void login(String username,String password)
	{
		indexpage=new IndexPage();
		loginpage=indexpage.clickonSignIn();
		//homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=loginpage.login(username,password);
		String actualURL=homepage.getcurrentURL();
		String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);
	}

}
