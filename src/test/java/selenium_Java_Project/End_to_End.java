package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class End_to_End {

	public static void main(String[] args) throws InterruptedException {
		// End to End Script.
		
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();
																		
		ChromeOptions op = new ChromeOptions();
																		
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
																		
		//open the URL.
		driver.get("https://www.spicejet.com/");
																		
		//Maximize the Browser.
		driver.manage().window().maximize();
																		
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//check radio button is selected or not.
		driver.findElement(By.xpath("//div[contains(text(),'one way')]")).click();
		
		//select from
		driver.findElement(By.xpath("(//div[@tabindex='0']//input[@type='text'])[1]")).click();		
		driver.findElement(By.xpath("//div[starts-with(text(),'Bhopal')]")).click();
		
		Thread.sleep(2000);
		
		//select to
		driver.findElement(By.xpath("//div[contains(text(),'Bengaluru')]")).click();
		
		//select date
		driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();
		
		//select adults
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		Thread.sleep(2000);
		
		//Adding adults				
		int i = 1;
		while (i<9)
		{
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
			i++;
		}
		
		    driver.findElement(By.xpath("//div[contains(text(), 'Currency')]")).click();
		
		//select radio button.
		driver.findElement(By.xpath("//div[contains(text(), 'Family & Friends')]")).click();
		Thread.sleep(2000);
			
		//click on flight button.
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();

	}

}
