package pptPreparation;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Selectclassexample {
	public static void main(String[] args) {
		        //Invoking Browser.
				WebDriverManager.chromedriver().setup();																										
				ChromeOptions op = new ChromeOptions();																										
				op.addArguments("--remote-allow-origins=*");
				ChromeDriver driver = new ChromeDriver(op);																								
				//open the URL.
				driver.get("https://rahulshettyacademy.com/angularpractice/");																								
				//Maximize the Browser.
				driver.manage().window().maximize();																								
				//implicitly wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				//dropdown.
				WebElement value_drop = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
				Select dropdown_value = new Select(value_drop);
				dropdown_value.selectByVisibleText("Female");		
	}
}
