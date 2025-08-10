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
public class OrderConformationPage extends BaseClass {
	

	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement orderSucessMsg;
	
	public OrderConformationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public String SuccessMessage()
	{
		String confirmText=orderSucessMsg.getText();
		return confirmText;
		
	}

}
