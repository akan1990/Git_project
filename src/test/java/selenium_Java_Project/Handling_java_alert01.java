package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handling_java_alert01 {

	public static void main(String[] args) {
		// Handling java alert01.
		
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
		
		//click on confirm.
		driver.findElement(By.id("confirmbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().dismiss();
	
	}

}
