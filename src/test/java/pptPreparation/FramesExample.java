package pptPreparation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExample {

	public static void main(String[] args) throws InterruptedException {
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
				
		//Maximize the Browser.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		//open the URL.
		driver.get("https://the-internet.herokuapp.com/");
		
		//go to the link.
		driver.findElement(By.linkText("Nested Frames")).click();
		Thread.sleep(3000);
		
		//Switch to frame by name/id
		driver.switchTo().frame(2);
    	System.out.println(driver.findElement(By.id("content")).getText());
		

	}

}
