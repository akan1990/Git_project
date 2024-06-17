package selenium_Java_Project;

public class Core_java_Brushup2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] num = {2, 4, 5, 7, 8, 10, 12, 14, 16};
		
		//Print only even numbers.
		for (int i=0; i<num.length; i++)
		{
			if (num[i]%2 == 0)
			{
				System.out.println(num[i]);				
			}
			else
			{
				System.out.println(num[i] + "These numbers are not divided by 2.");
			}
										
		}
							
	}

}
