package selenium_Java_Project;

import java.util.Arrays;
import java.util.List;

public class ArrayList01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] name = {"Apple", "Orange", "Kiwi", "Watermelon"};
		
		List<String> nameArrayList = Arrays.asList(name);
		
		System.out.println(nameArrayList.contains("Orange"));

	}

}
