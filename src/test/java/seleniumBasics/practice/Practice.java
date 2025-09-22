package seleniumBasics.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.get("https://www.amazon.in/");
//		driver.navigate().back();
//		driver.navigate().to("https://www.amazon.in");
		driver.quit();
	}
}
