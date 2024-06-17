package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_password_create {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();
										
		ChromeOptions op = new ChromeOptions();
										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
																				
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String name = "rahul";
		String password = getPassword(driver);
		
		//open the URL.
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
												
		//Maximize the Browser.
		driver.manage().window().maximize();
			
		//driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		//driver.findElement(By.id("inputUsername")).sendKeys(name);
		//driver.findElement(By.cssSelector("input[placeholder=Password]")).sendKeys(password);
		//driver.findElement(By.cssSelector("button.submit")).click();
		//Thread.sleep(5000);
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[2]")).click();
		String Passwordtext = driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(Passwordtext);
		String[] passwordArray = Passwordtext.split("'");
		String password = passwordArray[1].split("'")[0];
		return password;
				
	}
		
}
