package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase 
{
    @FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
    WebElement contactsLabel;
    
    @FindBy(xpath="//a[contains(@href,'/contacts/new')]")
    WebElement NewcontactsLink;
    
    @FindBy(name="first_name")
    WebElement FirstName;
    
    @FindBy(name="last_name")
    WebElement LastName;
    
    //@FindBy(xpath="//div[@name='channel_type']")
    //WebElement scocialchannel;
    
    
    @FindBy(xpath="//div[@name='company']")
    WebElement company;
    
    @FindBy(xpath="//button[@class='ui linkedin button']")
    WebElement btnsave;
    
   public ContactPage()
   {
	   PageFactory.initElements(driver, this);
   }
   
   //here we are selecting test2 test2  value in contacts later it may change so we need to pass as a parameter (name) here
   public boolean verifyconatctsLabel()
   {
	   return contactsLabel.isDisplayed();
   }
   
   public void selectcontactsByName(String name)  
   {
	 driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
   }
   
   public void createNewContact(String Fname,String LName) throws InterruptedException
   {
	   
	   NewcontactsLink.click();
	   FirstName.sendKeys(Fname);
	   Thread.sleep(6000);
	   LastName.sendKeys(LName);
	   Thread.sleep(6000);
	   //company.sendKeys(comp);
	   Thread.sleep(6000);
	   //Select selectobj=new Select(driver.findElement(By.xpath("//div[@name='channel_type']")));
	   //selectobj.selectByVisibleText(channel);
	   btnsave.click();
   }
		   
		   
		  
   
	
}
