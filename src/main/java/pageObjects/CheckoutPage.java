package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractComponents.abstractcomponent;
public class CheckoutPage extends abstractcomponent {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action__submit")
	 WebElement placeOrder;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;

	By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public void SelectCountry(String countryname)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, countryname).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
	}
	
	public ConfirmationPage SubmitOrder() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", placeOrder);
		Thread.sleep(2000);
		placeOrder.click();
		return new ConfirmationPage(driver);
	}
}
