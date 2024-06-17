package oops_Concepts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InheritanceExample_Parentclass {
	
	@BeforeMethod
	public void beforeRun()
	{
		System.out.println("Run me First.");
	}
	
	@Test
	public void DoThis()
	{
		System.out.println("I am here.");
	}
	
	@AfterMethod
	public void RunAfter()
	{
		System.out.println("Run me After.");
	}
}
