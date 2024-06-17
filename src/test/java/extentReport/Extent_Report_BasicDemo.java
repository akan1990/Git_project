package extentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_Report_BasicDemo {

	public static void main(String[] args) throws InterruptedException {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("Google serach", "This is a Test to validate google functionality");
        
       //Invoking Browser.
       WebDriverManager.chromedriver().setup();      																						
       ChromeOptions op = new ChromeOptions();     																						
       op.addArguments("--remote-allow-origins=*");
       ChromeDriver driver = new ChromeDriver(op);
       
       // log(Status, details)
       test.log(Status.INFO, "Starting TestCase");
       
       //open the URL.
       driver.get("https://www.google.com/");
              						
       //Maximize the Browser.
       driver.manage().window().maximize();
       
       test.pass(" Navigated to Google page ");
		   																						
       //implicitly wait
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       WebElement search_text = driver.findElement(By.id("APjFqb"));
       search_text.sendKeys("Automation step by step");
       Thread.sleep(2000);
       
       test.pass("Entered search text in searchbox");
       search_text.sendKeys(Keys.RETURN);
       
       test.pass("pressed Enter Key");
       
       driver.close();
       driver.quit();
       
       test.pass("Successfully close the Browser");
       test.info("Test Completed");
       
       // calling flush writes everything to the log file
       extent.flush();      
	}
}
