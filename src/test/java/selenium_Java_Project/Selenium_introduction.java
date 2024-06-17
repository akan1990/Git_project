package selenium_Java_Project;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_introduction {
	
	public static void main(String[] args) {
		
		//Invoking Browser
		//ChromeDriver -> methods
		//ChromeDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions op = new ChromeOptions();
		
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
		
		//open the URL.
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Maximize the Browser.
		driver.manage().window().maximize();
		
		//get the title of the URL.
		System.out.println(driver.getTitle());
		
		//get the actual url.
		System.out.println(driver.getCurrentUrl());
		
		//Close the browser.
		driver.close(); 
				
	}

}
