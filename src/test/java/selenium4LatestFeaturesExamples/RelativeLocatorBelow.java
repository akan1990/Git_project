package selenium4LatestFeaturesExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorBelow {

	public static void main(String[] args) {
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
				
		//Maximize the Browser.
		driver.manage().window().maximize();
		
		//open the URL.
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//implicitly wait.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

	}

}
