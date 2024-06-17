package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_on_mixed_chapters {

	public static void main(String[] args) throws InterruptedException {
		// Assignment on mixed chapters.
		//1. Select any checkbox.
		//2. Grab the label of the selected checkbox.
		//3. Select an option in dropdown.
		//4. Enter the step 2 grabbed label text in Editbox.
		//5. Click Alert & then verify if text grabbed from step 2 is present in the pop-up messgae.
		
		        //Invoking Browser.
				WebDriverManager.chromedriver().setup();																										
				ChromeOptions op = new ChromeOptions();																										
				op.addArguments("--remote-allow-origins=*");
				ChromeDriver driver = new ChromeDriver(op);
						
				//Maximize the Browser.
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						
				//open the URL.
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				//select checkbox.
				driver.findElement(By.id("checkBoxOption1")).click();
				String checkbox_option = driver.findElement(By.id("checkBoxOption1")).getText();
				
				//select dropdown value.
				WebElement drop_value = driver.findElement(By.id("dropdown-class-example"));
				Select dropdown = new Select(drop_value);
				
				//select dropdown by value.
				dropdown.selectByValue(checkbox_option);
				//Enter text in Alert text box.
				driver.findElement(By.id("name")).sendKeys(checkbox_option);
				
				//click on Alert button.
				driver.findElement(By.id("alertbtn")).click();
				Thread.sleep(3000);
				
				//Switch to Alert pop-up window and grab the text from Alert pop-up window.
				String alert_text = driver.switchTo().alert().getText();
				if(alert_text.contains(checkbox_option))
				{
					System.out.println("Successfully Verify the text in Alert pop-up window");
				}
				else
				{
					System.out.println("Not verified");
				}
												
	   }

}
