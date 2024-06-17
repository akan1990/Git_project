package oops_Concepts;
import org.testng.annotations.Test;

public class InheritanceExample_ChildClass extends InheritanceExample_Parentclass {
	
	@Test
	public void TestRun()
	{
		PS2 ps2 = new PS2(3);  //Parameterized Constructor
		int a = 3;
		DoThis();
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());
		
		PS3 ps3 = new PS3(3);
		System.out.println(ps3.multiplyThree());
		System.out.println(ps3.multiplyTwo());
	}
}
