package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_static_dropdown {

	public static void main(String[] args) {
		// Handle static Dropdown.
		
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
		
		WebElement static_dropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		
		//Dropdown with 'select' tag
		Select dropdown = new Select(static_dropdown);
		
		//Select dropdown by index.
		dropdown.selectByIndex(3);
		
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//Select dropdown by visible Text.
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//Select dropdown by select value.
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
	}

}
