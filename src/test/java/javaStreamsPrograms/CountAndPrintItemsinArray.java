package javaStreamsPrograms;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.testng.annotations.Test;

public class CountAndPrintItemsinArray {
	
	@Test
	public void StreamFilterOperation()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("David");
		names.add("Akash");
		names.add("Parvathi");
		names.add("Don");
	
	Long L1 = Stream.of("Abhijeet", "David", "Akash", "Parvathi", "Don").filter(s->
	{
		s.startsWith("A");
		return true;
	}).count();
	System.out.println(L1);
	//print all the names of ArrayList.
	names.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));
   }
}
