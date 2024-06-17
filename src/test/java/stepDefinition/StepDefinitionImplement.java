package stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;
import pageObjects.loginPage;
import testComponents.BaseTest;

public class StepDefinitionImplement extends BaseTest {
	
	public loginPage login;
	public WebDriver driver;
	public LandingPage landingPage;
	public ProductCatalogue productcatalogue;
	public ConfirmationPage confirmationpage;
	@Given("I landed on Ecommerce Webpage")
	public void I_landed_on_Ecommerce_Webpage() throws IOException
	{
//		login = new loginPage(driver);		
		landingPage = new LandingPage(driver);
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productcatalogue = landingPage.loginApplication(username, password);
	}
	
	@When("^I add Product (.+) to cart$")
	public void I_add_Product_to_cart(String productName)
	{
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.AddProductTocart(productName);
	}
	
	@When("^Checkout (.+) and Submit the Order$")
	public void Checkout_Submit_Order(String productName) throws InterruptedException
	{
		CartPage cartpage = productcatalogue.GoToCartPage();
		Boolean match = cartpage.VerifyProductDisplay(productName);		
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.selectCountry("india");
		confirmationpage = checkoutpage.SubmitOrder();	
	}
	
	@Then ("{string} message is displayed on ConfirmationPage")
	public void displayed_on_ConfirmationPage(String string)
	{
		String confirmMessage = confirmationpage.GetConfirmationmessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
}
