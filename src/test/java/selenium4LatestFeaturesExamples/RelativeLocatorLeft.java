package selenium4LatestFeaturesExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorLeft {

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
				
				WebElement Icecreamlabel = driver.findElement(By.xpath("//label[contains(text(), 'Check me out if you Love IceCreams!')]"));
				
				//Click checkbox which is on left.
				driver.findElement(with(By.tagName("input")).toLeftOf(Icecreamlabel)).click();

	}

}
