package selenium_Java_Project;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scope_of_links {

	public static void main(String[] args) throws InterruptedException {
		// Scope of links.
		//1. Give me the count of links on the page.
	    //2.Give me the count of Footersection.
		//3. Links count only from the first column.
		//4. click on each link from the first column in footersection.
		 //Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
				
		//Maximize the Browser.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		//open the URL.
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Find the Links.
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Find the Footer links.
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));  //Limiting WebDriver scoop.
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//Links count only from the first column in footersection.
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//4. click on each link from the first column in footersection & check if the pages are opening.
		for(int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++)
		{
			String clickon_newtab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickon_newtab);
			Thread.sleep(5000);
		}
		//Opens all the tabs
		Set<String> windows_tab = driver.getWindowHandles();
	    Iterator<String> it_tab = windows_tab.iterator();
			
		while(it_tab.hasNext())
		{
			driver.switchTo().window(it_tab.next());
			System.out.println(driver.getTitle());
		}
			
	}

}


