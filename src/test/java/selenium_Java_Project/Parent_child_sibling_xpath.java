package selenium_Java_Project;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Parent_child_sibling_xpath {
	public static void main(String[] args) {
		// Parent-child-sibling xpath.		
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();										
		ChromeOptions op = new ChromeOptions();										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);										
		//open the URL.
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");										
		//Maximize the Browser.
		driver.manage().window().maximize();										
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		//goto login
		WebElement loginbtn = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]"));
		loginbtn.getText();
		System.out.println(loginbtn.getText());
	}
}
