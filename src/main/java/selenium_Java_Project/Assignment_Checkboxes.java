package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_Checkboxes {

	 public static void main(String[] args) {
	 // Verify The checkboxes are successfully checked or unchecked.		
	 //Invoking Browser.
	 WebDriverManager.chromedriver().setup();		
	 ChromeOptions op = new ChromeOptions();																						
	 op.addArguments("--remote-allow-origins=*");
	 ChromeDriver driver = new ChromeDriver(op);
																						
	 //open the URL.
	 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
																						
	 //Maximize the Browser.
	 driver.manage().window().maximize();
																						
	 //implicitly wait
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 
	 //Count no. of CheckBoxes.
	 System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	 
	 Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
	 
	 driver.findElement(By.name("checkBoxOption1")).click();
	 
	 Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected());
	 
	 System.out.println(driver.findElement(By.name("checkBoxOption1")).isSelected());	 
	}
}
