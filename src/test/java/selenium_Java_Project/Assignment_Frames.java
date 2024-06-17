package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_Frames {

	public static void main(String[] args) throws InterruptedException {
		// Assignment on Frame.
		
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
				
				//Switch to frame.
				driver.switchTo().frame("frame-top");
				driver.switchTo().frame("frame-middle");
				System.out.println(driver.findElement(By.id("content")).getText());
				
	}

}
