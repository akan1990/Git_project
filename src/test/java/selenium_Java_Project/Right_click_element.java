package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Right_click_element {

	public static void main(String[] args) {
		  // Right click on element.
		  //Invoking Browser.
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions op = new ChromeOptions();
		  op.addArguments("--remote-allow-origins=*");
		  ChromeDriver driver = new ChromeDriver(op);
				
		 //open the URL.
		 driver.get("https://www.amazon.com/");
				
		 //Maximize the Browser.
		 driver.manage().window().maximize();
				
	     //implicitly wait
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
	    //Actions class moves to specific element.
	    Actions a = new Actions(driver);
	    WebElement move = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	    a.moveToElement(move).contextClick().build().perform();
	    
	}

}
