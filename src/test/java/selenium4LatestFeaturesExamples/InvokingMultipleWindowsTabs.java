package selenium4LatestFeaturesExamples;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokingMultipleWindowsTabs {

	public static void main(String[] args) throws InterruptedException {
		 //Scemario: Navigate to https://rahulshettyacademy.com/angularpractice/ fill the name field with
		 //the first course name available at https://rahulshettyacademy.com
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
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String ParentWindowId = it.next();
		String ChildWindowId = it.next();
		driver.switchTo().window(ChildWindowId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(ParentWindowId);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		Thread.sleep(2000);
		driver.quit();
		
	}

}
