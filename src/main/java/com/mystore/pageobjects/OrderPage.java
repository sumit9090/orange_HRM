package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	
	@FindBy(xpath="//li[@class='price']")
	WebElement unitPrice;
	
	@FindBy(xpath="//li[@class='price']")
	WebElement totalPrice;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtoCheckOutBtn;
	
	
	
	public OrderPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice()
	{
		Action.fluentWait(getDriver(), unitPrice, 10);
		String result=unitPrice.getText();
		String Unit=result.replaceAll("[^a-zA-Z0-9]", "");//removing dollar symbol
		double unitPrice=Double.parseDouble(Unit);//it will not be containing dot, so need to use /100
		return unitPrice/100;
	}
	
	public double getTotalPrice()
	{Action.fluentWait(getDriver(), unitPrice, 10);
		String result=totalPrice.getText();
		String totalPrice=result.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice=Double.parseDouble(totalPrice);
		Action.fluentWait(getDriver(), unitPrice, 10);
		return finalTotalPrice/100;
	}
	
	
	
	public LoginPage clickonproceedtoCheckOut()
	{
		Action.click(getDriver(), proceedtoCheckOutBtn);
		return new LoginPage();
	}

}
