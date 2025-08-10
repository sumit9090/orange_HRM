package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreation;
	
	
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
	@Test(groups="Smoke")
	public void createAccountTest()
	{
		indexpage=new IndexPage();
		loginpage=indexpage.clickonSignIn();
		accountcreation=loginpage.createNewAccount(prop.getProperty("createAccountEmailid"));
		accountcreation.ValidatecreateAccountText();
		
		
	}

}
