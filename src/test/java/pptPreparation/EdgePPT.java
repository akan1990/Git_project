package pptPreparation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgePPT {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions op = new EdgeOptions();
		op.addArguments("--remote-allow-origins=*");
		EdgeDriver driver = new EdgeDriver(op);
		driver.get("https://www.amazon.com/");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.navigate().refresh();

	}

}
