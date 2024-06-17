package pptPreparation;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class AlertpopupExample {	
	public static void main(String[] args) throws InterruptedException {
		 //Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(op);						
		//Maximize the Browser.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));						
		//open the URL.
		driver.get("https://demowebshop.tricentis.com/");
		//click on search button.
		driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
}
