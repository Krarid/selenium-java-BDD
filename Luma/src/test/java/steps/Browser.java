package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.Home;
import page.objects.Product;

public class Browser {
	
	protected WebDriver driver;
	protected Home home;
	protected Product product;
	
	public Browser()
	{
		driver = new ChromeDriver();
		home = new Home(driver);
		product = new Product(driver);
	}
	
}
