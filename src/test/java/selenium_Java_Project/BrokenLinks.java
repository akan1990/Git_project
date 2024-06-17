package selenium_Java_Project;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		        //Invoking Browser.
				WebDriverManager.chromedriver().setup();																										
				ChromeOptions op = new ChromeOptions();																										
				op.addArguments("--remote-allow-origins=*");
				ChromeDriver driver = new ChromeDriver(op);
						
				//Maximize the Browser.
				driver.manage().window().maximize();
				
				//Broken URL.
				//Step-1: Get all the URLs tied up with the Links.
				//Java methods will call all the URLs and get you the Status code.
				//If Status code > 400, then the URL is not working -> Broken Links.
										
				//open the URL.
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				//implicitly wait.
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
				
				//Open Connection method.
				HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int responsecode = conn.getResponseCode();
				System.out.println(responsecode);

	}

}
