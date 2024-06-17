package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();
				
		ChromeOptions op = new ChromeOptions();
				
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
				
		//open the URL.
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
		//Maximize the Browser.
		driver.manage().window().maximize();
				
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Give username and password.
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("abcd");
		
		driver.findElement(By.xpath("//input[@name='username']")).clear();
						
	}

}
