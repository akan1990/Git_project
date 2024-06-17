package selenium_Java_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();
								
		ChromeOptions op = new ChromeOptions();
								
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);
								
		//open the URL.
		driver.get("http://demo.nopcommerce.com/");
								
		//Maximize the Browser.
		driver.manage().window().maximize();
								
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		//choose radio button.
		driver.findElement(By.cssSelector("input[value='F']")).click();
		
		//css selector using regular expression.
		driver.findElement(By.cssSelector("input[id*='First']")).sendKeys("urmila");
		
		driver.findElement(By.id("LastName")).sendKeys("singh");
		
		//xpath using regular expression.
		driver.findElement(By.xpath("//a[contains(@class, 'ico-log')]")).click();
		
		//click on the Jewellery text.
		driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[6]")).click();
		
		//Get the Text.
		WebElement Jwe = driver.findElement(By.tagName("h1"));
		System.out.println(Jwe.getText());
		Assert.assertEquals(Jwe.getText(), "Jewelry");
		
		//click wishlist.
		driver.findElement(By.cssSelector("a[class='ico-wishlist'] span")).click();
		
		//click Computers
		driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
				
	}

}
