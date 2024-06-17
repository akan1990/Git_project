package selenium_Java_Project;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_handle {

	public static void main(String[] args) throws InterruptedException {
		// Window handles demo.
		
		        //Invoking Browser.
		        WebDriverManager.chromedriver().setup();
		        ChromeOptions op = new ChromeOptions();
		        op.addArguments("--remote-allow-origins=*");
		        ChromeDriver driver = new ChromeDriver(op);
				
		        //open the URL.
		        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
				
				//Maximize the Browser.
				driver.manage().window().maximize();
				
			    //implicitly wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				//click on the link.
				driver.findElement(By.cssSelector("a.blinkingText")).click();
				Thread.sleep(3000);
				Set<String> windows = driver.getWindowHandles();   //Store parent and child window id.
				Iterator<String> it = windows.iterator();
				String parentid = it.next();
				String childid = it.next();
				
				//switch to window.
				driver.switchTo().window(childid);
				System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
				String email_id = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
				driver.switchTo().window(parentid);
				driver.findElement(By.id("username")).sendKeys(email_id);
				
	}

}
