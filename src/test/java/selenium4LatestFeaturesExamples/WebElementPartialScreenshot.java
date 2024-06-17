package selenium4LatestFeaturesExamples;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementPartialScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		         //Capture WebElement Screenshot.
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
				WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
				nameField.sendKeys(courseName);
				File file = nameField.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File("logo.png"));
	}

}
