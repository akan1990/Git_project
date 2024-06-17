package testNGTutorials;

import org.testng.annotations.Test;

public class DemoTest {
	
	@Test(groups= {"Smoke"})
	public void Greetings()
	{
		System.out.println("Hello");
	}
	
	@Test
	public void secondtest()
	{
		System.out.println("Bye");
	}

}
