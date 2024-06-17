package selenium_Java_Project;

public class Methods_in_Java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Methods_in_Java d1 = new Methods_in_Java();
		String name = d1.getData();
		System.out.println(name);
		
		Methods_Demo d2 = new Methods_Demo();
		d2.getuserData();
						
	}
	
	public String getData()
	{
		System.out.println("Hello world");
		return "Rahul Kumar";
	}

}
