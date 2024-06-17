package selenium_Java_Project;

public class Core_Java_Brushup1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 10;
		String my_name = "Akanksha";
		char ch = 'A';
		double s = 10.00;
		boolean my_city = true;
		
		System.out.println(num);
		System.out.println(my_name);
		System.out.println(ch);
		System.out.println(s);
		System.out.println(my_city);
		
		int[] my_arr = new int[5];
		my_arr[0] = 1;
		my_arr[1] = 2;
		my_arr[2] = 3;
		my_arr[3] = 4;
		my_arr[4] = 5;
		
		int[] arr = {5, 7, 2, 3, 4, 5, 6};
		System.out.println(arr[2]);
		
		//using for loop to iterate.
		for (int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		
		String[] name_data = {"Rahul", "Ankur", "Saba", "Payal"};
		
		for (int j=0; j<name_data.length; j++)
		{
			System.out.println(name_data[j]);
		}
		
		//Enhanced for loop.
		for (String s1 : name_data)
		{
			System.out.println(s1);
		}
		
	}

}
