package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertion {

	public static void main(String[] args) {
		        //Invoking Browser.
				WebDriverManager.chromedriver().setup();																										
				ChromeOptions op = new ChromeOptions();																										
				op.addArguments("--remote-allow-origins=*");
				ChromeDriver driver = new ChromeDriver(op);
						
				//Maximize the Browser.
				driver.manage().window().maximize();
				
				//open the URL.
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				//implicitly wait.
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

}
