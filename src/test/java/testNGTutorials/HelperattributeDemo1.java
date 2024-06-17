package testNGTutorials;
import org.testng.annotations.Test;
public class HelperattributeDemo1 {
	@Test
	public void Registration()
	{
		System.out.println("This is Registration page.");
	}
	@Test
	public void fillName()
	{
		System.out.println("Entered FirstName");
	}
	@Test(dependsOnMethods={"Registration","fillName"})
	public void Submit()
	{
		System.out.println("Submitted Successfully.");
	}
}
