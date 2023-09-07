package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Items {
	
	@FindBy(id = "page-title-heading")
	@CacheLookup
	private WebElement title;
	
	private WebDriver driver;
	
	public Items(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void IsUserInThePage(String page)
	{
		Assert.assertEquals(title.getText(), page);
	}
}
