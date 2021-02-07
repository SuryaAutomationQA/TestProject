package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends LoginPage
{
	//Page factory 
	
	@FindBy(xpath="//span[contains(text(),'surya surya')]")
	WebElement UsernameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycorrectusernameDisplaying()
	{
		return UsernameLabel.isDisplayed();
	}
	
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactPage clickoncontactsLink()
	{
		contactsLink.click();
		return new ContactPage();
		
	}
	
	//public void clickonNewconatctsLink()
	//{
		// Actions action=new Actions(driver);
		 // action.moveToElement(contactsLink).build().perform();
		
	//}
	
	
	
	public DealsPage clickonDealsLink()
	{
		DealsLink.click();
		return new DealsPage();
		
	}
	
	public TasksPage clickonTasksLink()
	{
		TasksLink.click();
		return new TasksPage();
		
	}
	
	

}
