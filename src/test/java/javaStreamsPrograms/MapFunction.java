package javaStreamsPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class MapFunction {
	
	@Test
	public void StraemMap()
	{
		//Print names which have last letter i with Uppercase.
		Stream.of("Abhijeet", "Imli", "Akashi", "Parvathi", "Don").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Print names which have first letter as a with Uppercase & sorted.
		List<String>names = Arrays.asList("Abhijeet", "Imli", "Akashi", "Parvathi", "Don");
		names.stream().filter(s-> s.startsWith("A")).sorted().map(s-> s.toUpperCase()).forEach(s-> System.out.println(s));
	}	
}
