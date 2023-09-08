package page.objects;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(css = "li.product-item")
	@CacheLookup
	private List<WebElement> items;
	
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
	
	public void isItemDisplayedInThePage(String itemName)
	{
		boolean isDisplayed = false;
		
		for( WebElement item : items ) {
			if( item.findElement(By.cssSelector("strong a")).getText().contains(itemName) ) {
				isDisplayed = true;
				break;
			}
		}
		
		Assert.assertTrue(isDisplayed);
	}
}
