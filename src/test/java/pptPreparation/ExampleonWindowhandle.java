package pptPreparation;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ExampleonWindowhandle {
	public static void main(String[] args) throws InterruptedException {
		//Invoking Browser.
		WebDriverManager.chromedriver().setup();																										
		ChromeOptions op = new ChromeOptions();																										
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);				
		//Maximize the Browser.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));				
		//open the URL.
		driver.get("https://the-internet.herokuapp.com/");		
		//Go to link of multiple windows.
		driver.findElement(By.partialLinkText("Multiple Windows")).click();
		Thread.sleep(3000);		
		//move on new window.
		driver.findElement(By.partialLinkText("Click Here")).click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();   //Store parent & child window id.
		Iterator<String> ite = windows.iterator();
		String parent_id = ite.next();
		String child_id = ite.next();
	}
}
