package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion_explain {

	public static void main(String[] args) {
		// Assertion example
		
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
				
		//Count the no. of checkboxes.
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());
				
		driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).click();
		
		Assert.assertTrue(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());
				
		System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());

	}

}

