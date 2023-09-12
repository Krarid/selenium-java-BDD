package page.objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {
	
	@FindBy(css = "input[name='login[username]']")
	@CacheLookup
	private WebElement username;
	
	@FindBy(css = "input[name='login[password]']")
	@CacheLookup
	private WebElement password;
	
	@FindBy(css = "fieldset.login button[name='send']")
	@CacheLookup
	private WebElement signIn;
	
	@FindBy(css = "div.message-error > div")
	@CacheLookup
	private WebElement errorLogin;
	
	private WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterCredentials(String user, String psw )
	{
		username.sendKeys(user);
		password.sendKeys(psw);
		signIn.click();
	}
	
	public void isLoginErrorMessageDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-error > div")));
		
		Assert.assertEquals(errorLogin.getText(), "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}
}
