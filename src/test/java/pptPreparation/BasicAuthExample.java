package pptPreparation;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BasicAuthExample {
	public static void main(String[] args) {
		        //Invoking Browser.
				WebDriverManager.chromedriver().setup();																										
				ChromeOptions op = new ChromeOptions();																										
				op.addArguments("--remote-allow-origins=*");
				WebDriver driver = new ChromeDriver(op);						
				//Maximize the Browser.
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));						
				//open the URL.
				driver.get("https://the-internet.herokuapp.com/basic_auth");
	}
}

