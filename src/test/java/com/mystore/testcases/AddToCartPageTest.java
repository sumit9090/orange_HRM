package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest  extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
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
	public void addToCartTest()
	{
		indexpage=new IndexPage();;
		searchresultpage=indexpage.searchProduct("tshirt");
		addtocartpage=searchresultpage.clickonProduct();
		addtocartpage.selectSize();
		addtocartpage.enterQuantity("2");
		addtocartpage.clickonAddtoCartBtn();
		 boolean result = addtocartpage.addtoCartMessage();
		 Assert.assertTrue(result);
		 
	
		
		
	}
	
	

}
