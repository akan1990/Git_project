package javaStreamsPrograms;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FiltertheWebTableusingJavaStreams {

	public static void main(String[] args) {
		        //Invoking Browser.
				WebDriverManager.chromedriver().setup();																										
				ChromeOptions op = new ChromeOptions();																										
				op.addArguments("--remote-allow-origins=*");
				ChromeDriver driver = new ChromeDriver(op);
						
				//Maximize the Browser.
				driver.manage().window().maximize();
				
				//open the URL.
				driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
				
				//implicitly wait.
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				driver.findElement(By.id("search-field")).sendKeys("Rice");
				List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
				List<WebElement> filteredList = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).
				collect(Collectors.toList());
				Assert.assertEquals(veggies.size(), filteredList.size());
	}
}
