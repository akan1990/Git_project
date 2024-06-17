package testNGTutorials;
import org.testng.annotations.Test;
public class Priorityhelperattribute {
	@Test(priority=1)
	public void loginpage()
	{
		System.out.println("This is loginpage.");
	}
	@Test(priority=2)
	public void logoutpage()
	{
		System.out.println("This is logout.");
	}

}
