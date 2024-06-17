package testComponents;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;
	public static Properties prop;	
	
//	public static Properties loadPropertiesFile() throws IOException
//	{
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\GlobalData.properties");
//		prop = new Properties();
//		prop.load(file);
//		return prop;
//	}			
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(file);
		String browserName = prop.getProperty("browser");
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(op);				
		driver.get(prop.getProperty("Appurl"));			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
		
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.GoTo();		
		return landingpage;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	@AfterMethod(alwaysRun=true)
	public void TearDown()
	{
		 driver.close();
	}
}
