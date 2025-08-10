package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='email']")
	WebElement signinUserName;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement signinUserPassword;
	
	@FindBy(xpath="//span[normalize-space()='Sign in']")
	WebElement signinSubmitButton;
	
	@FindBy(name="email_create")
	WebElement emailAddressTextBox;
	
	@FindBy(xpath="//span[normalize-space()='Create an account']")
	WebElement CreateAccountBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String userName,String password)
	{
		Action.type(signinUserName, userName);
		Action.type(signinUserPassword, password);
		Action.click(getDriver(), signinSubmitButton);
		return new HomePage();
	}
	
	
	public AddRessPage login1(String userName,String password)
	{
		Action.type(signinUserName, userName);
		Action.type(signinUserPassword, password);
		Action.click(getDriver(), signinSubmitButton);
		return new AddRessPage();
	}
	
	public AccountCreationPage createNewAccount(String emailAddress)
	{
		Action.type(emailAddressTextBox, emailAddress);
		
		Action.click(getDriver(), signinSubmitButton);
		return new AccountCreationPage();
	}
	
	

}
