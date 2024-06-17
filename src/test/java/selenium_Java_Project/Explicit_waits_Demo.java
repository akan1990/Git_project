package selenium_Java_Project;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicit_waits_Demo {
	
	public static void main(String[] args) {
		// Adding item into cart.
				
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
						
		//Maximize the Browser.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String[] veggies = {"Cucumber", "Brocolli", "Beetroot"};
																										
		//open the URL.
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");																																																				
		addItems(driver, veggies);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		WebElement actual_text = driver.findElement(By.cssSelector("span.promoInfo"));
		System.out.println(actual_text.getText());
		Assert.assertEquals(actual_text.getText(), "Code applied ..!");
						
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
						
		for(int i = 0; i < products.size(); i++)
		{
				 String[] name = products.get(i).getText().split("-");
				 String formatted_name = name[0].trim();
				//format it to get actual vegetable name
				//convert array into array list for easy search.
				//check whether name you extracted is present in arrayList or not.
							
				List veggieslist = Arrays.asList(veggies);
						
		}
					        
	}
			
			public static void addItems(WebDriver driver, String[] veggies)
			{
				int j = 0;
			List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
				for(int i = 0; i < products.size(); i++)
				{
						String[] name = products.get(i).getText().split("-");
				        String formatted_name = name[0].trim();
						//format it to get actual vegetable name
						//convert array into array list for easy search.
						//check whether name you extracted is present in arrayList or not.
							
						List veggieslist = Arrays.asList(veggies);
							
			if (veggieslist.contains(formatted_name))
				       {
					    j++;
						    //Click on Add to cart
						   driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
								
						   if (j==3)
						   {
							   break;
						   }
						
				    }
					        
			     }

			}

	}


