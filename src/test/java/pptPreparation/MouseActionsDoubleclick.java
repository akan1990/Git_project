package pptPreparation;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class MouseActionsDoubleclick {
	public static void main(String[] args) {
		        //Invoking Browser.
				WebDriverManager.chromedriver().setup();
				ChromeOptions op = new ChromeOptions();
				op.addArguments("--remote-allow-origins=*");
				ChromeDriver driver = new ChromeDriver(op);				
				//open the URL.
				driver.get("https://www.amazon.in/");				
				//Maximize the Browser.
				driver.manage().window().maximize();				
			    //implicitly wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));				
				//Actions class moves to specific element.
				Actions a = new Actions(driver);					
				//select text by doubleclick.
				a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().
				keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	}
}
