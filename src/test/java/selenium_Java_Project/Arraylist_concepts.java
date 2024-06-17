package selenium_Java_Project;

import java.util.ArrayList;

public class Arraylist_concepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String>a = new ArrayList<String>();
		
		//Create object of the class - object.method
		a.add("Abhishek");
		a.add("Sadaphal");
		a.add("Photon");
		a.add("Infotech");
		a.remove(3);
		
		//Extract values
		System.out.println(a.get(0));
		
		//Iterating over ArrayList using for loop.
		for(int i=0; i<a.size(); i++)
		{
			System.out.println(a.get(i));
		}
		
		System.out.println("******************************");
		
		//Using Enhanced for loop.
		for (String var : a)
		{
			System.out.println(var);
		}
		
		//Item present in ArrayList.
		System.out.println(a.contains("Photon"));
		
	}

}
