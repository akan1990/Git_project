package pptPreparation;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class GetthelinkTextofAllLinks {
	public static void main(String[] args) {
		        //Invoking Browser.
		        WebDriverManager.chromedriver().setup();																										
				ChromeOptions op = new ChromeOptions();																										
				op.addArguments("--remote-allow-origins=*");
				ChromeDriver driver = new ChromeDriver(op);				
				//Maximize the Browser.
				driver.manage().window().maximize();		
				//open the URL.
				driver.get("https://demowebshop.tricentis.com/");		
				//implicitly wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				List<WebElement> books = driver.findElements(By.xpath("//div[@class='block block-category-navigation']"));
				for (WebElement Bookname : books)
				{
					System.out.println(Bookname.getText());
					break;
				}
	}
}
