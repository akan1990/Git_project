package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_test {

	public static void main(String[] args) {
		// Frame test Demo.
		
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(op);
				
		//Maximize the Browser.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		//open the URL.
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
			
		//Perform drag & drop using Actions class.
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		//Return back from frame.
		driver.switchTo().defaultContent();

	}

}
