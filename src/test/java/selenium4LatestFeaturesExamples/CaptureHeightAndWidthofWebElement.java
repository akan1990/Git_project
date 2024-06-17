package selenium4LatestFeaturesExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureHeightAndWidthofWebElement {

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
		
		WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(nameField.getRect().getDimension().getHeight());
		System.out.println(nameField.getRect().getDimension().getWidth());

	}

}
