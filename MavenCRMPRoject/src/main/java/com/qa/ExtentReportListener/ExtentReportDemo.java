
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BasicExtentReportgenerate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ExtentHtmlReporter htmlReporter = new Exte
				 ntHtmlReporter("extent.html");
	        // create ExtentReports and attach reporter(s)
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	     // creates a toggle for the given test, adds all log events under it    
            ExtentTest MYTEST = extent.createTest("Google Search", "To validate the ggogle search functionality");     
            System.setProperty("webdriver.gecko.driver","C:\\Users\\ADMIN\\Downloads\\geckodriver.exe");
		     WebDriver driver=new FirefoxDriver();
		     driver.get("https://google.com");
		     
		     MYTEST.log(Status.INFO,"starting my test case");
		    // driver.get(url);
		     driver.findElement(By.name("q")).sendKeys("selenium automation");
		     MYTEST.pass("entered text in search box");
		     //driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		    // MYTEST.pass("pressed the click button");
		     driver.close();
		     driver.quit();        
		     //MYTEST.pass("closed the browser");
		     MYTEST.pass("compoleted the test");
		  // calling flush writes everything to the log file
		        extent.flush();
	
	}

}
