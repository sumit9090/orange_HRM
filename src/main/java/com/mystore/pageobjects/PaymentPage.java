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
public class PaymentPage extends BaseClass {
	
	@FindBy(xpath="//a[@title='Pay by bank wire']//span[contains(text(),'(order processing will be longer)')]")
	WebElement Paybybankwire;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement Paybycheck;
	
	
	
	
	
	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummaryPage clickonPaymentMethod()
	{
		Action.click(getDriver(), Paybybankwire);
		return new OrderSummaryPage();
	}
	
	

}
