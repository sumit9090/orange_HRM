/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="//li[4]//div[1]//h5[1]//a[1]")
	WebElement printedsummerdress;
	
	public SearchResultPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isproductAvailable()
	{
		return Action.isDisplayed(getDriver(), printedsummerdress);
		
	}
	
	public AddToCartPage clickonProduct()
	{
		Action.click(getDriver(), printedsummerdress);
		return new AddToCartPage();
	}

}
