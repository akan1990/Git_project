package oops_Concepts;

public class ConstructorParameter {
	
	int Modelyear;
	String modelName;
	
	public ConstructorParameter(int year, String name)
	{
		Modelyear = year;
		modelName = name;
	}

	public static void main(String[] args) {
		ConstructorParameter obj1 = new ConstructorParameter(1990, "Mustang");
		System.out.println("Model year is: " + "  " + obj1.Modelyear + " and" + " "+ "Modelname is: " + "  " + obj1.modelName);
	}
} 
