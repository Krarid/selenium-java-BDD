package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
	
	@FindBy(id = "product-addtocart-button")
	@CacheLookup
	private WebElement addToCart;
	
	@FindBy(css = "div.minicart-wrapper > a")
	@CacheLookup
	private WebElement cart;
	
	@FindBy(css = "div.product > div.product-item-details > strong > a")
	@CacheLookup
	private WebElement product;
	
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
	
	public void selectColor(int color)
	{
		colors.get(color).click();
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
	
	public void isItemInTheCart()
	{
		
		cart.click();
		Assert.assertEquals(product.getText(), "Hero Hoodie");
	}
}
