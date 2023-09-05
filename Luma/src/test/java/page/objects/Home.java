package page.objects;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Home {
	
	private WebDriver driver;
	private String url = "https://magento.softwaretestingboard.com/";
  
	@BeforeTest
  	public void beforeTest() 
  	{
		driver = new ChromeDriver();
		driver.get(url);
  	}
	
	@Test
	public void login() 
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "Home Page");
	}
	
	@Test
	public void signIn()
	{
		WebElement signIn = driver.findElement(By.cssSelector("li > a[href*='login']"));
		signIn.click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Customer Login");
	}

	@AfterTest
  	public void afterTest() 
  	{
		driver.quit();
  	}
}