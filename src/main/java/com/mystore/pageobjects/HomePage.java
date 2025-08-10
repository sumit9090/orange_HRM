package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	
	
	@FindBy(xpath="//span[normalize-space()='Order history and details']")
	WebElement orderHistoryandDetails;
	
	@FindBy(xpath="//span[normalize-space()='My addresses']")
	WebElement myAddressess;
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateorderHistoryDetails()
	{
		return Action.isDisplayed(getDriver(), orderHistoryandDetails);
		
	}
	
	public boolean myAddressess()
	{
		return Action.isDisplayed(getDriver(), myAddressess);
		
	}
	public String getcurrentURL()
	{
		String homepageURL=getDriver().getCurrentUrl();
		System.out.println(homepageURL);
		return homepageURL;
	}

}
