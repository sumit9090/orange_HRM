package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//a[@title='Log in to your customer account']")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@alt='My Shop']")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	

	@FindBy(name="submit_search")
	WebElement searchButton;
	
	
	//initialize webelements in the constructor
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickonSignIn()
	{
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		return Action.isDisplayed(getDriver(), myStoreLogo);
		
	}
	
	public String getmyStoreTitle()
	{
		return Action.getTitle(getDriver());
	}

	
	public SearchResultPage searchProduct(String productName)
	{
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}
}
