package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchresultpage;
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
	@Test(groups="Regression")
	public void productAvalibility()
	{
		indexpage=new IndexPage();;
		searchresultpage=indexpage.searchProduct("tshirt");
		boolean result=searchresultpage.isproductAvailable();
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void ClickonSearchedProduct()
	{
		indexpage=new IndexPage();;
		searchresultpage=indexpage.searchProduct("tshirt");
	
		
		
	}

}
