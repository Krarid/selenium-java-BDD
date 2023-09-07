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
}