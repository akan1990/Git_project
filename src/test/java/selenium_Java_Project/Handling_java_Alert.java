package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handling_java_Alert {

	public static void main(String[] args) throws InterruptedException {
		//Handling java Alert.
		
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();
			
		ChromeOptions op = new ChromeOptions();
																							
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
																							
		//open the URL.
		driver.get("https://demo.automationtesting.in/Alerts.html");
																							
		//Maximize the Browser.
		driver.manage().window().maximize();
																							
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();

	}

}
