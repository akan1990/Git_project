package pageObjects;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractcomponent;
public class LandingPage extends abstractcomponent{
	WebDriver driver;
	public Properties prop;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//PageFactory
	@FindBy(id="userEmail")
	WebElement user;	
	@FindBy(id="userPassword")
	WebElement passWord;	
	@FindBy(id="login")
	WebElement loginbtn;	
	public ProductCatalogue loginApplication(String username, String password)
	{
		user.sendKeys(username);
		passWord.sendKeys(password);
		loginbtn.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
	}		
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");	
	}	
}
