package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Home {
	
	@FindBy(css = ".navigation a[href*='what-is-new']")
	@CacheLookup
	private WebElement whatIsNew;
	
	@FindBy(css = "input#search")
	@CacheLookup
	private WebElement search;
	
	@FindBy(css = "div#search_autocomplete ul li")
	@CacheLookup
	private List<WebElement> searchAutocomplete;
	
	@FindBy(css = "ul > li.level0")
	@CacheLookup
	private List<WebElement> headers;
	
	private List<WebElement> sections;
	
	private List<WebElement> items;
	
	private WebElement reference;
	
	@FindBy(css = "div.header span.logged-in")
	@CacheLookup
	private WebElement welcome;
	
	@FindBy(css = "div.panel.header a[href*='login']")
	@CacheLookup
	private WebElement signIn;
	
	@FindBy(css = "div.panel.header a[href*='create']")
	@CacheLookup
	private WebElement createAccount;
	
	private WebDriver driver;
	private Actions builder;
	private String url = "https://magento.softwaretestingboard.com/";
	
	public Home(WebDriver driver)
	{
		this.driver = driver;
		this.builder = new Actions(this.driver);
		PageFactory.initElements(driver, this);
	}
	
	public void visitLuma()
	{
		driver.get(url);
	}
	
	public void clickOnWhatIsNew()
	{
		whatIsNew.click();
	}
	
	public void searchItem(String item)
	{
		search.sendKeys(item);
	}
	
	public void hitEnterButton()
	{
		search.sendKeys(Keys.ENTER);
	}
	
	public void clickOnAutocomplete()
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div#search_autocomplete ul li")));
		
		searchAutocomplete.get(0).click();
	}
	
	public void goToHeader(String header)
	{
		for( WebElement h: headers ) {
			if( h.getText().equalsIgnoreCase(header) ) {
				builder.moveToElement(h).perform();
				reference = h;
			}
		}
	}
	
	public void goToSection(String section)
	{
		sections = reference.findElements(By.cssSelector("a + ul > li.level1"));
		
		for( WebElement s: sections ) {
			if( s.getText().equalsIgnoreCase(section) ) {
				builder.moveToElement(s).perform();
				reference = s;
			}
		}
		
		builder.moveToElement(reference);
	}
	
	public void goToItem(String item)
	{
		items = reference.findElements(By.cssSelector("a + ul > li.level2"));
		
		for(WebElement i: items) {
			if( i.getText().equalsIgnoreCase(item) ) {
				reference = i;
			}
		}
	}
	
	public void goToLogin()
	{
		signIn.click();
	}
	
	public void goToCreateAccount()
	{
		createAccount.click();
	}
	
	public void clickOnReference()
	{
		reference.click();
	}
	
	public void wasUserLoggedIn()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until( ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.header span.logged-in"), "Welcome" ));
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/");
		Assert.assertTrue(welcome.getText().contains("Welcome"));
	}
}