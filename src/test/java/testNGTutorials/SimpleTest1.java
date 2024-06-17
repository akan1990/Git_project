package testNGTutorials;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleTest1 {
	
	@BeforeClass
	public void KpmgLogin()
	{
		System.out.println("This is KPMG Login.");
	}
	
	@Test(groups= {"Smoke"})
	public void HomeLoan()
	{
		System.out.println("HomeLoan Department");
	}
	
	@BeforeMethod
	public void SmartPhone()
	{
		System.out.println("This cellphone is Smart.");
	}
	
	@AfterMethod
	public void SmartCellPhone()
	{
		System.out.println("This cellphone is Smart and Durable.");
	}
	
	@AfterClass
	public void KpmgLogout()
	{
		System.out.println("This is KPMG Logout.");
	}
	
	@Test
	public void HomeLoanLogin()
	{
		System.out.println("HomeLoanLogin Department");
	}
	
	@Test
	public void HomeLoanLogindepartment()
	{
		System.out.println("HomeLoanLoginout Department");
	}
	
	@BeforeSuite
	public void HomeLoanLogindepartmentone()
	{
		System.out.println("HomeLoanLoginout DepartmentOne.");
	}
	
	@Test
	public void CarLoan()
	{
		System.out.println("CarLoan Department");
	}
	
	@Test(dependsOnMethods= {"CarLoan","HomeLoanLogindepartment"})
	public void PersonalLoan()
	{
		System.out.println("PersonalLoan Department");
	}
	
	@Test(dataProvider="TPCLweblogin")
	public void RegistrationPage(String username, String password)
	{
		System.out.println("Registration Page Displayed.");
		System.out.println(username);
		System.out.println(password);
	}
	
	@DataProvider
	public Object[][] TPCLweblogin()
	{
		//1st Combination- username password- Good Credit Hietory
		//2nd Combination- username password- no credit History
		//3rd Combination- Fradulent credit History
		Object data[][] = new Object [3][2];
		//1st Combination
		data[0][0] = "firstsetusername";
		data[0][1] = "firstpassword";
		//Columns in the row are nothing but values for that particular combination(Rows).
		//2nd Combination.
		data[1][0] = "secondsetusername";
		data[1][1] = "secondpassword";
		//3rd Combination.
		data[2][0] = "thirdusername";
		data[2][1] = "thirdpassword";
		return data;
	}

}