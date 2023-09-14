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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;

public class Checkout {
	
	@FindBy(id = "customer-email")
	@CacheLookup
	private WebElement emailAddress;
	
	@FindBy(css = "input[name='firstname']")
	@CacheLookup
	private WebElement firstName;
	
	@FindBy(css = "input[name='lastname']")
	@CacheLookup
	private WebElement lastName;
	
	@FindBy(css = "input[name='street[0]']")
	@CacheLookup
	private WebElement street;
	
	@FindBy(css = "input[name='city']")
	@CacheLookup
	private WebElement city;
	
	@FindBy(css = "select[name='region_id']")
	@CacheLookup
	private WebElement state;
	
	@FindBy(css = "input[name='postcode']")
	@CacheLookup
	private WebElement postalCode;
	
	@FindBy(css = "select[name='country_id']")
	@CacheLookup
	private WebElement country;
	
	@FindBy(css = "input[name='telephone']")
	@CacheLookup
	private WebElement telephone;
	
	@FindBy(css = "tbody > tr.row")
	@CacheLookup
	private List<WebElement> shippingMethod;
	
	@FindBy(xpath = "//span[contains(text(), 'Next')]/parent::button")
	@CacheLookup
	private WebElement nextButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Place Order')]/parent::button")
	@CacheLookup
	private WebElement placeOrderButton;
	
	private WebDriver driver;
	
	public Checkout(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillShippingAddress(DataTable details)
	{
		emailAddress.sendKeys(details.row(1).get(0));
		firstName.sendKeys(details.row(1).get(1));
		lastName.sendKeys(details.row(1).get(2));
		street.sendKeys(details.row(1).get(3));
		city.sendKeys(details.row(1).get(4));
		postalCode.sendKeys(details.row(1).get(6));
		telephone.sendKeys(details.row(1).get(8));
		
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText(details.row(1).get(7));
		
		Select selectState = new Select(state);
		selectState.selectByVisibleText(details.row(1).get(5));
		
		for( WebElement s: shippingMethod ) {
			if( s.findElement(By.cssSelector("td:nth-child(3)")).getText().equalsIgnoreCase(details.row(1).get(9)) )
				s.findElement(By.cssSelector("td:nth-child(1) > input")).click();
		}
	}
	
	public void next()
	{
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(20) );
		
		if( nextButton.isDisplayed() ) {
			nextButton.click();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[alt='Loading...']")));
	}
	
	public void placeOrder()
	{
		WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10) );
		
		placeOrderButton.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Thank you')]/parent::h1")));
	}
	
	public void wasTheOrderSuccessful()
	{
		Assert.assertEquals( driver.getCurrentUrl() , "https://magento.softwaretestingboard.com/checkout/onepage/success/");
	}
}
