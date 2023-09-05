package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.Home;

public class Browser {
	
	protected WebDriver driver;
	protected Home home;
	
	public Browser()
	{
		driver = new ChromeDriver();
		home = new Home(driver);
	}
	
}
