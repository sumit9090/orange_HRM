/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * 
 */
public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath="//select[@id='group_1']")
	WebElement productdropdown;
	
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement quantity;
	
	@FindBy(xpath="//span[normalize-space()='Add to cart']")
	WebElement addToCartbutton;
	
	
	@FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
	WebElement proceedtoChecOutBtn;
	
	public AddToCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void selectSize()
	{
		 Action.selectByIndex(productdropdown, 1);
		Action.fluentWait(getDriver(), productdropdown, 10);
	}
	
	public void enterQuantity(String quantity1)
	{
		Action.type(quantity, quantity1);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void clickonAddtoCartBtn()
	{
		Action.click(getDriver(), addToCartbutton);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public boolean addtoCartMessage()
	{
		Action.fluentWait(getDriver(), addToCartMessage, 10);
		 return Action.isDisplayed(getDriver(), addToCartMessage);
		 
		
	}

	
	public OrderPage proceedtoCheckout()
	{
		Action.fluentWait(getDriver(), proceedtoChecOutBtn, 10);
		Action.JSClick(getDriver(), proceedtoChecOutBtn);
		
		return new OrderPage();
	}
}
