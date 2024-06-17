package pptPreparation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

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
		driver.findElement(By.cssSelector("a[class='ico-login']")).click();
		driver.findElement(By.id("Email")).sendKeys("Test.User@company.com");
		driver.findElement(By.id("Password")).sendKeys("password");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
	}
}
