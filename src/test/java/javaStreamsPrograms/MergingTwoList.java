package javaStreamsPrograms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MergingTwoList {
	
	@Test
	public void StreamMergingList()
	{
		List<String>names = Arrays.asList("Abhijeet", "Imli", "Akashi", "Parvathi", "Don");
		List<String>names1 = Arrays.asList("Azbhijeet", "Imli", "Akashi", "Parvathi", "Don");		
		//Merging Two Different List.
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		boolean flag = newStream.anyMatch(s-> s.equalsIgnoreCase("Azbhijeet"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void StreamCollect()
	{
		List<String> ls = Stream.of("Abhijeet", "Imli", "Akashi", "Parvathi", "Don").filter(s->s.endsWith("i")).map(s->
		s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
	}
}
