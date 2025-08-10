package com.mystore.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
	
	@Test(groups="Sanity")
	public void ValidateorderHistoryDetails()
	{
		indexpage=new IndexPage();
		loginpage=indexpage.clickonSignIn();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		boolean orderhistory=homepage.validateorderHistoryDetails();
		Assert.assertTrue(orderhistory);
	}
	
	
	@Test(groups="Sanity")
	public void ValidatemyAddress()
	{
		indexpage=new IndexPage();
		loginpage=indexpage.clickonSignIn();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean address=homepage.myAddressess();
		Assert.assertTrue(address);
	}

}
