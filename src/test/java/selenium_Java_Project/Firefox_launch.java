package selenium_Java_Project;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Firefox_launch {

	public static void main(String[] args) {
		
		//Invoking Firefox Browser.
		WebDriverManager.firefoxdriver().setup();
		
		FirefoxDriver driver = new FirefoxDriver();
		
		//launch URL.
		driver.get("https://www.google.com/");

	}

}
