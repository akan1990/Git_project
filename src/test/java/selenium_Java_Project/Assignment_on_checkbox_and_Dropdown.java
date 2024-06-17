package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_on_checkbox_and_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// Assignment on Checkbox and Dropdown.
	
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
																						
		//open the URL.
		driver.get("https://rahulshettyacademy.com/angularpractice/");
																						
		//Maximize the Browser.
		driver.manage().window().maximize();
																						
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Fill the field name.
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("akanksha");
		
		//Fill the field email.
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='email']")).sendKeys("akkuminti@gmail.com");
		
		//fill the password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("akan9893@");
		
		//check the checkbox.
		driver.findElement(By.id("exampleCheck1")).click();		
		System.out.println(driver.findElement(By.id("exampleCheck1")).isSelected());		
		//dropdown.
		WebElement value_drop = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		Select dropdown_value = new Select(value_drop);
		dropdown_value.selectByVisibleText("Female");		
		driver.findElement(By.id("inlineRadio1")).click();
		
		//select DOB.
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("10/04/1990");
		
		driver.findElement(By.cssSelector(".btn")).click();
		
		Thread.sleep(2000);
		
		WebElement capture_text = driver.findElement(By.cssSelector(".alert"));
		System.out.println(capture_text.getText());

	}

}
