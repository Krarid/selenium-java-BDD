package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Product {
	@FindBy(css = "div.size > div.clearfix > div.swatch-option")
	@CacheLookup
	private List<WebElement> sizes;
	
	@FindBy(css = "div.clearfix > div.color")
	@CacheLookup
	private List<WebElement> colors;
	
	@FindBy(css = "input#qty")
	@CacheLookup
	private WebElement quantity;
	
	@FindBy(id = "product-addtocart-button")
	@CacheLookup
	private WebElement addToCart;
	
	@FindBy(css = "div.minicart-wrapper > a")
	@CacheLookup
	private WebElement cart;
	
	@FindBy(xpath = "//button[contains(text(), 'Proceed')]")
	@CacheLookup
	private WebElement proceed;
	
	@FindBy(css = "div.product > div.product-item-details > strong > a")
	@CacheLookup
	private WebElement product;
	
	@FindBy(css = "#minicart-content-wrapper > div.block-content > strong")
	@CacheLookup
	private WebElement cartMessage;
	
	private WebDriver driver;
	
	public Product(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectSize(int size)
	{
		sizes.get(size).click();
	}
	
	public void selectSize(String size)
	{
		for( WebElement s: sizes ) {
			if( s.getAttribute("option-label").equalsIgnoreCase(size) )
				s.click();
		}
	}
	
	public void selectColor(int color)
	{
		colors.get(color).click();
	}
	
	public void selectColor(String color)
	{
 		
		for( WebElement c: colors ) {
			if( c.getAttribute("option-label").equalsIgnoreCase(color) )
				c.click();
		}
	}
	
	public void addQuantity(String qty)
	{
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public void addToCart()
	{
		addToCart.click();
		
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
		
		try {
			wait.until(ExpectedConditions.attributeContains(addToCart, "title", "Add to Cart"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	
	public void clickOnCart()
	{
		cart.click();		
	}
	
	public void proceedToCheckout()
	{
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
		
		proceed.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("customer-email")));
	}
	
	public void areThereItemsInTheShippingCart()
	{
		Assert.assertEquals(cartMessage.getText(), "You have no items in your shopping cart.");
	}
}
