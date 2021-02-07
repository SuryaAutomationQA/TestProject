package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;	
	public TestBase() 
			{
			try 
				{
					prop= new Properties();
FileInputStream ip=new FileInputStream("D:\\Selenium\\Workspace1\\MavenCRMPRoject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
					                  
					prop.load(ip);	
		System.out.println("hey my browser *****"+prop.getProperty("browser"));			
		
				}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			}

	public static void Initialization()
		{
				String browser=prop.getProperty("browser");
				System.out.println("my browser is"+prop.getProperty("browser"));
				if(browser.equals("chrome"))
				{
					System.setProperty("Webdriver.chrome.driver", "D:\\Selenium\\chromedriver");
					driver=new ChromeDriver();
				}
				else if(browser.equals("FF"))
				{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ADMIN\\Downloads\\geckodriver.exe");
				      driver=new FirefoxDriver();
				}
	         
	              driver.manage().window().maximize();
	              driver.manage().deleteAllCookies();
	              //here to avoid hardcode created the time in util class
	              driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	              driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	              driver.get(prop.getProperty("url"));
			         
		}
}