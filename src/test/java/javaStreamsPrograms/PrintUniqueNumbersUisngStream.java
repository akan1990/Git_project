package javaStreamsPrograms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.Test;

public class PrintUniqueNumbersUisngStream {
	
	@Test
	public void StraemUnique()
	{
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		//Print Unique Number from this List.
		values.stream().distinct().forEach(s->System.out.println(s));
		//Sort the array and print 3rd Index.
		List<Integer> l1 = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(l1.get(2));
	}	
}
