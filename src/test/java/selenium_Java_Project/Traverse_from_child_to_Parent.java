package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Traverse_from_child_to_Parent {

	public static void main(String[] args) {
		// Traverse from child to parent.
		
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
		
		//go to login.
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
	}

}
