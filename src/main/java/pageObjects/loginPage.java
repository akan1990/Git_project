package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	public WebDriver ldriver;
	
	public loginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userName;	
	@FindBy(id="userPassword")
	WebElement passWord;	
	@FindBy(id="login")
	WebElement loginbtn;
	
	public void setUsername(String username)
	{
		userName.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		passWord.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}

}
