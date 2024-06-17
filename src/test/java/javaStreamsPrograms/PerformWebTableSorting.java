package javaStreamsPrograms;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
public class PerformWebTableSorting {
	
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
		
		//Sort on the Original List.
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//Compare Original List and Sorted List.
		Assert.assertTrue(originalList.equals(sortedList));		
	}
}
