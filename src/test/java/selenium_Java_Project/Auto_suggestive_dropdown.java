package selenium_Java_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Auto_suggestive_dropdown {

	public static void main(String[] args) throws InterruptedException {
		// Handle Auto-Suggestive Dropdown.
		
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
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		
		Thread.sleep(3000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option : options)
		{
			if (option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
			
		}
		
						
	}

}

