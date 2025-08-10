/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * 
 */
public class IndexPageTest extends BaseClass {
	 IndexPage indexPage;
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
	public void verifyLogo()
	{
		indexPage=new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertFalse(result);
	}
	
		@Test(groups="Sanity")
	public void verifyTitle()
	{
		String Actualtitle=indexPage.getmyStoreTitle();
		Assert.assertEquals(Actualtitle, "My Shop");
		
	}

}
