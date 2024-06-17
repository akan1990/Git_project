package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCookies {

	public static void main(String[] args) {
		        //Invoking Browser.
				WebDriverManager.chromedriver().setup();
				ChromeOptions op = new ChromeOptions();
				op.addArguments("--remote-allow-origins=*");
				ChromeDriver driver = new ChromeDriver(op);
				
				//Maximize the Browser.
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
																										
				//open the URL.
				driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
																																																				
				//implicitly wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
