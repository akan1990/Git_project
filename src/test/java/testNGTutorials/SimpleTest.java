package testNGTutorials;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SimpleTest {
	
	@AfterSuite
	public void DemoSimple()
	{
		System.out.println("Hi This is DemoSimple Test.");
	}
	
	@AfterTest
	public void Demo1()
	{
		System.out.println("Hi How are you?");
	}
	
	@Test(groups= {"Smoke"})
	public void Demo()
	{
		System.out.println("Hi");
	}
	
	@Parameters({"URL"})
	@Test
	public void test1(String urlname)
	{
		System.out.println("Good Morning");
		System.out.println(urlname);
	}
	
	@BeforeTest
	public void test2()
	{
		System.out.println("It will take First.");
	}

}
