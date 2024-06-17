package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingHTTPSCertification {

	public static void main(String[] args) {
		        //Invoking Browser.
		        WebDriverManager.chromedriver().setup();
		        ChromeOptions op = new ChromeOptions();
		        op.setAcceptInsecureCerts(true);
		        op.addArguments("--remote-allow-origins=*");
		        ChromeDriver driver = new ChromeDriver(op);
		        																								
				//open the URL.
				driver.get("https://expire.badssl.com/");
																								
				//Maximize the Browser.
				driver.manage().window().maximize();
				System.out.println(driver.getTitle());
																								
				//implicitly wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
