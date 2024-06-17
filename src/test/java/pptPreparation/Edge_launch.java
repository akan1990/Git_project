package pptPreparation;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edge_launch {

	public static void main(String[] args) {
		
		//Invoking Browser.
		WebDriverManager.edgedriver().setup();
		
		EdgeDriver driver = new EdgeDriver();
		
		//Maximize the Browser.
		driver.manage().window().maximize();
		
		//Launch URL.
		driver.get("https://www.google.com/");

	}

}
