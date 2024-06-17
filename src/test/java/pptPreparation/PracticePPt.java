package pptPreparation;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class PracticePPt {
	public static void main(String[] args) {
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);				
		//Maximize the Browser.
		driver.manage().window().maximize();		
		//open the URL.
		driver.get("https://demowebshop.tricentis.com/books");		
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		List<WebElement> items = driver.findElements(By.xpath("//input[@value='Add to cart']"));
		for (WebElement item : items) {
		    item.click();
		    break;
		}
	}

}
