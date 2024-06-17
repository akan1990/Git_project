package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignmemnt_on_mixed_chapters01 {

	public static void main(String[] args) throws InterruptedException {
		//1. Select any checkbox.
		//2. Grab the label of the selected checkbox.//put into a variable.
		//3. Select an option in dropdown. Here option to select should come from step 2.
		//4. Enter the step 2 grabbed label text in Editbox.
		//5. Click Alert & then verify if text grabbed from step 2 is present in the pop-up messgae.
		
		 //Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
				
		//Maximize the Browser.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		//open the URL.
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Select checkbox.
		driver.findElement(By.id("checkBoxOption1")).click();
		String chckvalue = driver.findElement(By.id("checkBoxOption1")).getText();
		
		//dropdown
		WebElement drpdwnvalue = driver.findElement(By.id("dropdown-class-example"));
		Select s1 = new Select(drpdwnvalue);
		
		//select by value.
		s1.selectByValue(chckvalue);
		
		//alert box.
		driver.findElement(By.id("name")).sendKeys(chckvalue);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		
		//Switch to alertpopup window.
		String alertbox = driver.switchTo().alert().getText();
		if (alertbox.contains(chckvalue))
		{
			Assert.assertTrue(true, "The checkbox value is present");
		}
		else
		{
			System.out.println("Not verified");
		}
		
	}

}
