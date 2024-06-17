package oops_Concepts;

public class Constructor {
	
	int x;               //set the class Attribute.
	public Constructor()
	{
		x = 5;         //Set values of class attribute x.
	}

	public static void main(String[] args) {
		Constructor myobj = new Constructor();     //creating object of class.(This will call the constructor)
		System.out.println(myobj.x);
	}
}
