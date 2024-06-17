package javaStreamsPrograms;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class CountTheNumberofNamesStartingwithA {
	
	//Count the number of Names starting with 'A'.
	//@Test
	public void regular()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("David");
		names.add("Akash");
		names.add("Parvathi");
		names.add("Don");
		int count = 0;
		
		for (int i=0; i<names.size(); i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count ++;
			}
		}
		System.out.println(count);		
	}
	
	@Test
	public void StreamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("David");
		names.add("Akash");
		names.add("Parvathi");
		names.add("Don");
		
		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
		
		Long d = Stream.of("Abhijeet", "David", "Akash", "Parvathi", "Don").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		//Print all the names of ArrayList.
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
	}
}