package javaStreamsPrograms;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BuildCustomSeleniumMethods {

	public static void main(String[] args) {
		        //Invoking Browser.
				WebDriverManager.chromedriver().setup();																										
				ChromeOptions op = new ChromeOptions();																										
				op.addArguments("--remote-allow-origins=*");
				ChromeDriver driver = new ChromeDriver(op);
						
				//Maximize the Browser.
				driver.manage().window().maximize();
				
				//open the URL.
				driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
				
				//implicitly wait.
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				//Click on Column.
				driver.findElement(By.xpath("//tr/th[1]")).click();
				
				//Capture all webelements into list.
				List<WebElement> webelementlist = driver.findElements(By.xpath("//tr/td[1]"));
				
				//Capture text of all webElements into new(Original) List.
				List<String> originalList = webelementlist.stream().map(s->s.getText()).collect(Collectors.toList());
							
				//Scan the nameColumn with getText -> Beans->Print the Price of the Beans.
				List<String> Price = webelementlist.stream().filter(s->s.getText().contains("Beans")).
				map(s->getPriceVeggie(s)).collect(Collectors.toList());
				Price.forEach(a->System.out.println(a));
	}
	private static String getPriceVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		   return pricevalue;
	}
}
