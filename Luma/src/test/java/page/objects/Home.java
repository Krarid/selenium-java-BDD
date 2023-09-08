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
	
	private WebDriver driver;
	private String url = "https://magento.softwaretestingboard.com/";
	
	public Home(WebDriver driver)
	{
		this.driver = driver;
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
	
	public void clickOnAutocomplete()
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div#search_autocomplete ul li")));
		
		searchAutocomplete.get(0).click();
	}
}