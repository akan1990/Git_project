package selenium_Java_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_on_ExplicitWait {
	
	public static void main(String[] args) throws InterruptedException {
		// Assignment on ExplicitWait
				
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
		
		//Maximize the Browser.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//open the URL.
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//Fillthe login form
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		
		//Click on Radio button
		driver.findElement(By.xpath("//span[contains(text(), ' User')]")).click();
		Thread.sleep(3000);
		
		//Switching to Alert ExplicitWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		//select dropdown value
		WebElement dropdown_value = driver.findElement(By.xpath("//select[@class='form-control']"));
		
		//Dropdown with 'select' tag
		Select dropdown = new Select(dropdown_value);
		
		//Select dropdown by value.
		dropdown.selectByValue("consult");
		
		//click on checkbox.
		driver.findElement(By.cssSelector("input#terms")).click();
		
		//click on signin
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		for(int i=0; i<products.size(); i++)
		{
			products.get(i).click();
		}
		driver.findElement(By.partialLinkText("Checkout")).click();
		    
	}
		
}
