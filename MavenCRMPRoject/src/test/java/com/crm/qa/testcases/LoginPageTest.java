package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase 
{
	
	LoginPage SPLoginPage;
	HomePage homepage;
	//here we need to create constructor as it will call super --so it will initialize all the 
	//values form the parent constructor
	public  LoginPageTest() 
	{
		super(); 
	}
	
	
    @BeforeMethod
    public void setup() 
    {
     Initialization();
     SPLoginPage=new LoginPage();
    }
    
    @Test(priority=1)
    public void LoginPageTitleTest()
    {
    String title=SPLoginPage.validatelogintitle();
    System.out.println("Test case1 :verify the CRM title"+title);
    Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
    	
    }
    
    @Test(priority=2)
    public void CRMLogoTest() throws InterruptedException
    {
    	//Thread.sleep(6000);
    	boolean flag=SPLoginPage.validateCRMImage();
    	System.out.println("Test case 2 : Verify the CRMImage"+flag);
    	Assert.assertTrue(flag);
    }
    
    @Test(priority=3)
    public void LoginTest() 
    {
    	System.out.println("Test case 3:Login to HomePage");
    	homepage=SPLoginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
    }
    
    @AfterMethod
    public void teardown()
    {
    	System.out.println("quit the browser");
    	driver.quit();
    }
                
}
