package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handling_Calender {

	public static void main(String[] args) throws InterruptedException {
		// Handling calender
		
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();
																						
		ChromeOptions op = new ChromeOptions();
																						
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
																						
		//open the URL.
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
																						
		//Maximize the Browser.
		driver.manage().window().maximize();
																						
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.cssSelector("a[value='MAA']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//a[@value='BLR'][normalize-space()='Bengaluru (BLR)'])[2]")).click();
		
		//Pick a date from calender.
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
				
	}

}

