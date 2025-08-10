package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	
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
	public void verifyTotalPrice()
	{
		indexpage=new IndexPage();;
		searchresultpage=indexpage.searchProduct("tshirt");
		addtocartpage=searchresultpage.clickonProduct();
		addtocartpage.selectSize();
		addtocartpage.enterQuantity("2");
		addtocartpage.clickonAddtoCartBtn();
		orderpage=addtocartpage.proceedtoCheckout();
		double unitprice = orderpage.getUnitPrice();
		double totalprice=orderpage.getTotalPrice();
		double expectedtotalprice=(unitprice*2)+7;
		System.out.println(expectedtotalprice);
		System.out.println(totalprice);
	}

}
