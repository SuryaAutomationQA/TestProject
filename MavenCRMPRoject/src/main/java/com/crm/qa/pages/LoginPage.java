package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	
	//@FindBy(name="surya")
	//WebElement name;
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement Home_Login_Button;
	
   //Page factory -OR
	@FindBy(name="email")
	WebElement Loginusername;
	
	@FindBy(name="password")
	WebElement LoginPassword;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement LoginButton;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement SignUp;
	
	
	@FindBy(xpath="//a[contains(text(),'Compare')]")
	WebElement CRM_Logo;
	
	public LoginPage()
	{
		//inint-->initilaize the elements and this means current class objects
		//all the elemnmts with the driver
		//Initializing the page objects
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, this);
		
	}
	//********************Actions create here  **************************
	public String validatelogintitle()
	{   
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() 
	{
		//Thread.sleep(6000);
		//System.out.println("check in the method CRM image value*****"+CRM_Logo);
		CRM_Logo.isDisplayed();
		return CRM_Logo.isDisplayed();
		
	}
	
	public HomePage Login(String un,String pd) 
	{  
		//Thread.sleep(3000);
		Home_Login_Button.click();
		Loginusername.sendKeys(un);
		LoginPassword.sendKeys(pd);
		LoginButton.click();
		return new HomePage();
	}
	
	
}
