package oops_Concepts;

public class StaticAndPublicMethod {
	
	//Static Method
	static void StaticMethod()
	{
		System.out.println("This is Static Method.");
	}
	
	//Public Method
	public void PublicMethod()
	{
		System.out.println("This is Public Method.");
	}

	public static void main(String[] args) {
		
		StaticMethod();   //call the static method.
		
		//Creating Object.
		StaticAndPublicMethod myobj = new StaticAndPublicMethod();
		myobj.PublicMethod();   //call the public method on the object.
	}

}
