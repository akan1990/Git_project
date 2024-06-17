package pptPreparation;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ActionClassContextclick {
	public static void main(String[] args) {
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);				
		//open the URL.
		driver.get("https://demowebshop.tricentis.com/");				
		//Maximize the Browser.
		driver.manage().window().maximize();				
	    //implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));				
		//Actions class moves to specific element.
		Actions a = new Actions(driver);					
		//Store Register link web Element.
		WebElement Register_link = driver.findElement(By.cssSelector("a[class='ico-register']"));		
		a.contextClick(Register_link).build().perform();
	}
}
