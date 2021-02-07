package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase
{
	LoginPage SPLoginPage;
	HomePage myhomepage;
	ContactPage mycontactPage;
 public ContactsPageTest()
{
   super();
   
}

 @BeforeMethod
 public void setup() 
 {
  Initialization();
  SPLoginPage=new LoginPage();
  myhomepage=new HomePage();
  myhomepage=SPLoginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
  mycontactPage= Homepage.clickoncontactsLink();
 }	
 
 @Test(priority=1)
 public void verifyContactPageLabel()
 {
	 Assert.assertTrue(mycontactPage.verifyconatctsLabel(),"conatct page label is missing in the page");
 }
 
 @Test(priority=2)
 public void selectcontact()
 {
	 mycontactPage.selectcontactsByName("test2 test2");
 }
 
 @Test(priority=3)
 public void validatenewcontact() throws InterruptedException
 {
	 mycontactPage.createNewContact("surs", "ssps");
 }
 
 @DataProvider
 public void getTestdata(sheetname)
 {
	 
 }
 
 
 
 @AfterMethod
 public void tearDown()
 {
	driver.quit();
 }
 
 
 
 
 
 
}
