package projectAutomationFramework;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrderPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseTest;
public class TC_verifyAddProduct extends BaseTest {
		   
		String productName = "ZARA COAT 3";
		String CountryName = "india";
		String ExpectedResult = "THANKYOU FOR THE ORDER.";
	    
		@Test(groups={"Regression"})
		public void SubmitOrder() throws IOException, InterruptedException
		{
		ProductCatalogue productcatalogue = landingpage.loginApplication(prop.getProperty("userName"), ("passWord"));		
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.AddProductTocart(productName);
		CartPage cartpage = productcatalogue.GoToCartPage();
		Boolean match = cartpage.VerifyProductDisplay(productName);		
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.selectCountry(CountryName);
		ConfirmationPage confirmationpage = checkoutpage.SubmitOrder();	
		String confirmMessage = confirmationpage.GetConfirmationmessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(ExpectedResult));
	}
		
	@Test (dependsOnGroups= {"Regression"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productcatalogue = landingpage.loginApplication(prop.getProperty("userName"), ("passWord"));
		OrderPage orderpage = productcatalogue.GoToOrdersPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
	}
	
	@Test
	public void SelectCheckbox() throws InterruptedException
	{
		ProductCatalogue productcatalogue = landingpage.loginApplication(prop.getProperty("userName"), ("passWord"));
		CartPage cartpage = productcatalogue.ElectronicProduct();		
	}	
}
