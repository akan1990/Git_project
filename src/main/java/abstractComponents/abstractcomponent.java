package abstractComponents;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;
import pageObjects.OrderPage;
public class abstractcomponent {		
	WebDriver driver;	
	public abstractcomponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	@FindBy(css="[routerlink*='cart']")
	WebElement CartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrderHeader;

	public void waitForElementToAppear(By findBy)
	{
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage GoToCartPage()
	{
		CartHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public OrderPage GoToOrdersPage()
	{
		OrderHeader.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}	
}

