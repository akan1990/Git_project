package testNGTutorials;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SimpleTest2 {
	
	@Test(groups= {"Smoke"})
	public void LoginHomeLoan()
	{
		System.out.println("HomeLoan loginpage");
	}
	
	@Test(enabled=false)
	public void LoginCarLoan()
	{
		System.out.println("CarLoan loginpage");
	}
	
	@Test(timeOut=4000)
	public void LoginPersonalLoan()
	{
		System.out.println("PersonalLoan loginpage");
	}
	
	@Parameters({"URL", "APIKey/username"})
	@Test
	public void LogoutPersonalLoan(String urlname, String key)
	{
		System.out.println("PersonalLoan Logoutpage.");
		System.out.println(urlname);
		System.out.println(key);
	}

}
