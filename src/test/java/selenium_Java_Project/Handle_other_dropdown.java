package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_other_dropdown {

	public static void main(String[] args) throws InterruptedException {
		// Handle other Dropdown.
		
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
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		
		int i = 1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
			driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
				
	}

}

