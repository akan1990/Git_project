package extentReport;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_Report_Basic_Demo_with_TestNG {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ChromeDriver driver;
	
	@BeforeSuite
	public void setUp()
	{
        htmlReporter = new ExtentHtmlReporter("extentReports1.html");
		
		// create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);				
	}
	
	@BeforeTest
	public void setUpTest()
	{
		   //Invoking Browser.
	       WebDriverManager.chromedriver().setup();      																						
	       ChromeOptions op = new ChromeOptions();     																						
	       op.addArguments("--remote-allow-origins=*");
	       driver = new ChromeDriver(op);
	}
		
	@Test
	public void test1()
	{
		 // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("Google serach", "This is a Test to validate google functionality");
        //open the URL.
        driver.get("https://www.google.com/");
               						
        //Maximize the Browser.
        driver.manage().window().maximize();     
        test.pass(" Navigated to Google page ");
               
        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
	}
    
	@Test
	public void test2()
	{
	   // creates a toggle for the given test, adds all log events under it    
      ExtentTest test = extent.createTest("Google serach", "This is a Test to validate google functionality");
    
      // log(Status, details)
      test.log(Status.INFO, "This step shows usage of log(status, details)");

     // info(details)
     test.info("This step shows usage of info(details)");
    
      // log with snapshot
      test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
    
      // test with snapshot
      test.addScreenCaptureFromPath("screenshot.png");
      
	}
	
	@AfterTest
	public void tearDownTest()
	{
	driver.close();
    driver.quit();   
    System.out.println("Test Completed successfully");
	}
		
	@AfterSuite
	public void tearDown()
	{
		// calling flush writes everything to the log file
        extent.flush();
	}
}
