package selenium_Java_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
																								
		//open the URL.
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
																								
		//Maximize the Browser.
		driver.manage().window().maximize();
																								
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		driver.findElement(By.id("second_date_picker")).click();
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText().contains("May"))
		{
			driver.findElement(By.cssSelector("a[title='Next']")).click();
		}
		List<WebElement> dates = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		int count = driver.findElements(By.xpath("//td[@data-handler='selectDay']")).size();
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).getText();
			if(text.equalsIgnoreCase("16"))
			{
				driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).click();
				break;				
			}
			
		}
	
    }
	
}


