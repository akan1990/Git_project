package selenium_Java_Project;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowActivities {

	public static void main(String[] args) {
		// Window Activities.
		
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();
														
		ChromeOptions op = new ChromeOptions();
														
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
		
		//Maximize the Browser.
		driver.manage().window().maximize();
														
		//open the URL.
		driver.get("https://www.google.com/");
		
		//Navigate to other Browser.
		driver.navigate().to("https://rahulshettyacademy.com");
		driver.navigate().back();
		driver.navigate().forward();

	}

}
