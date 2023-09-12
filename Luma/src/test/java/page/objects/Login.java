package page.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
