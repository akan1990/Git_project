package pageObjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractComponents.abstractcomponent;
public class ProductCatalogue extends abstractcomponent {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(xpath = "(//div//input[contains(@type,'checkbox')])[12]")
	WebElement ElectronicCheck;
	
	@FindBy(xpath = "//div//h5//b")
	WebElement ProductSelect;
	
	By productsBy = By.cssSelector(".mb-3");
	By AddToCart = By.cssSelector(".card-body button:last-of-type");
	By Toastmessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;	
	}
	
	public void AddProductTocart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(AddToCart).click();
		waitForElementToAppear(Toastmessage);
		waitForElementToDisappear(spinner);
	}
	
	public CartPage ElectronicProduct() throws InterruptedException
	{
		ElectronicCheck.click();
		Thread.sleep(2000);
		System.out.println(ProductSelect.getText());
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}	
}
