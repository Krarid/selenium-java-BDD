package page.objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Items {
	
	@FindBy(id = "page-title-heading")
	@CacheLookup
	private WebElement title;
	
	@FindBy(css = "li.product-item")
	@CacheLookup
	private List<WebElement> products;
	
	@FindBy(css = "div.message.notice")
	@CacheLookup
	private WebElement noSearchMessage;
	
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
	
	public void isItemDisplayedInThePage(String product)
	{
		boolean isDisplayed = false;
		
		for( WebElement item : products ) {
			if( item.findElement(By.cssSelector("strong a")).getText().contains(product) ) {
				isDisplayed = true;
				break;
			}
		}
		
		Assert.assertTrue(isDisplayed);
	}
	
	public void isNoSearchMessageDisplayed(String noSearch)
	{
		Assert.assertEquals(noSearchMessage.getText(), noSearch );
	}
	
	public void clickOnProduct(String product)
	{		
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
		
		for( WebElement p : products ) {
			if( p.findElement(By.cssSelector("strong a")).getText().contains(product) ) {
				p.click();
				break;
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
	}
}
