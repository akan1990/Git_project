package selenium_Java_Project;

public class String_Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "London is a developed city";
		String[] splittedString = s.split(" is");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
	
		
		//Remove left and Right Spaces.
		System.out.println(splittedString[1].trim());
		
		//Using For loop.
		for (int i=0; i<s.length(); i++)
		{
			System.out.println(s.charAt(i));
		}
		
		//Print String in Reverse Order.
		for (int j=s.length()-1; j>=0; j--)
		{
			System.out.println(s.charAt(j));
		}
									
	}

}
