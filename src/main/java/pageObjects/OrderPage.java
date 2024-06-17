package pageObjects;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractComponents.abstractcomponent;
public class OrderPage extends abstractcomponent {
	WebDriver driver;
	@FindBy(css = ".totalRow button")
	WebElement checkoutbtn;

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> ProductNames;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean VerifyOrderDisplay(String productName) {
		Boolean match = ProductNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", checkoutbtn);
		Thread.sleep(2000);
		checkoutbtn.click();
		return new CheckoutPage(driver);
	}
}
