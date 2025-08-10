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
public class ShippingPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement checkbox_ShippingPage;
	
	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement ShippingPage_proceedtoCheckOutBtn;
	
	
	
	public ShippingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickonTerms()
	{
		Action.click(getDriver(), checkbox_ShippingPage);
	}
	
	
	public PaymentPage ShippingPage_clickonproceedtoCheckOut()
	{
		Action.click(getDriver(), ShippingPage_proceedtoCheckOutBtn);
		return new PaymentPage();
		
	}

}
