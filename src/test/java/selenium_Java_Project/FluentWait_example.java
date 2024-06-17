package selenium_Java_Project;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait_example {

	public static void main(String[] args) throws InterruptedException {
		// Fluentwait example
		
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
		
		//click on link
		driver.findElement(By.partialLinkText("Dynamic Load")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Example 1: Element on page")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div#start button")).click();
		
		//Fluent Wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement w = wait.until(new Function<WebDriver, WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("div#finish h4")).isDisplayed())
				{
					return driver.findElement(By.cssSelector("div#finish h4"));
				}
				else
				{
					return null;
				}
			}
		});
		
		System.out.println(driver.findElement(By.cssSelector("div#finish h4")).getText());
								
	}

}
