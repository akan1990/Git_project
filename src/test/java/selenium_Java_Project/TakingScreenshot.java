package selenium_Java_Project;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakingScreenshot {

	public static void main(String[] args) throws IOException {
		//Invoking Browser.
        WebDriverManager.chromedriver().setup();
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(op);
        
        //Maximize the Browser.
        driver.manage().window().maximize();
		
        //open the URL.
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
				
	    //implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\All_Details\\screenshot.png"));
	}

}
