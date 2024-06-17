package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrolldownPage {

	public static void main(String[] args) throws InterruptedException {
		
		 //Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
				
		//Maximize the Browser.
		driver.manage().window().maximize();
		
		//implicitly wait.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		//open the URL.
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//ScrollDown a Page.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(4000);
		
		//Scrolldown a Table Component.
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

	}

}
