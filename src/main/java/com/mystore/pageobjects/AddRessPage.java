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


public class AddRessPage extends BaseClass{
	@FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtoCheckOutBtn_AddressPage;
	
	
	
	public AddRessPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage AddRessPage_clickonproceedtoCheckOut()
	{
		Action.click(getDriver(), proceedtoCheckOutBtn_AddressPage);
		return new ShippingPage();
	}

}
