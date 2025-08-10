package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddRessPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConformationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;


public class EndToEndTest extends BaseClass{
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddRessPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummaryPage oredersummaypage;
	OrderConformationPage orderconformationpage;
	
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
	public void endToEndTest()
	{
		
		indexpage=new IndexPage();;
		
		searchresultpage=indexpage.searchProduct("tshirt");
		
		addtocartpage=searchresultpage.clickonProduct();
		
		addtocartpage.selectSize();
		
		addtocartpage.enterQuantity("2");
		addtocartpage.clickonAddtoCartBtn();

		orderpage=addtocartpage.proceedtoCheckout();
		
		
		loginpage=orderpage.clickonproceedtoCheckOut();
		addresspage=loginpage.login1("sumit.kalra121@gmail.com", "Pass@123");
		shippingpage=addresspage.AddRessPage_clickonproceedtoCheckOut();
		shippingpage.clickonTerms();
		paymentpage=shippingpage.ShippingPage_clickonproceedtoCheckOut();
		oredersummaypage=paymentpage.clickonPaymentMethod();
		orderconformationpage=oredersummaypage.clickonConfirmOrderBtn();
		String expectedMsg=orderconformationpage.SuccessMessage();
		String actualMsg="Your order on My Shop is complete.";
		Assert.assertEquals(actualMsg, expectedMsg);
		
		
	}

}
