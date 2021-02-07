package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class HomePageTest extends TestBase
{
	LoginPage SPLoginPage;
	HomePage myhomepage;
	ContactPage mycontactpage;
	public HomePageTest()
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
	    }	
	 
	 
	 //test cases should be independent
	 //before each test case  -launch the browser AND LOGIN
	 //@Test --execute each test case
	 //after each test case close the browser
	 @Test(priority=1)
	   public void verifyHomePageTitleTest() throws InterruptedException
	   {
		String HomePageTitle= myhomepage.verifyHomePageTitle();
		System.out.println("i am going to verify my homepage title****"+HomePageTitle);
	//the error message will be printed when the test case is failed 	
		Thread.sleep(7000);
		 Assert.assertEquals(HomePageTitle, "Cogmento CRM","Homepage title not matched");
	   } 
	 
	 @Test(priority=2)
	 public void VerifyUserNameTest() 
	 {
		 Assert.assertTrue(myhomepage.verifycorrectusernameDisplaying()); 
	 }
	 
	 @Test(priority=3)
	 public void VerifyContactsPageTest()
	 {
		 System.out.println("click on contact page link");
		 mycontactpage=myhomepage.clickoncontactsLink(); 
	 }
	
	@AfterMethod
	   public void tearDown()
	   {
		driver.quit();
	   }
	
	
}
