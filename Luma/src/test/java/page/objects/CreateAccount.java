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

import io.cucumber.datatable.DataTable;

public class CreateAccount {
	
	@FindBy(id = "firstname")
	@CacheLookup
	private WebElement firstName;
	
	@FindBy(id = "lastname")
	@CacheLookup
	private WebElement lastName;
	
	@FindBy(id = "email_address")
	@CacheLookup
	private WebElement email;
	
	@FindBy(id = "password")
	@CacheLookup
	private WebElement password;
	
	@FindBy(id = "password-confirmation")
	@CacheLookup
	private WebElement passwordConfirmation;
	
	@FindBy(css = "button[title='Create an Account']")
	@CacheLookup
	private WebElement createAccount;
	
	@FindBy(css = "div.message-success div")
	@CacheLookup
	private WebElement successMessage;
	
	private WebDriver driver;
	
	public CreateAccount(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillAccountDetails(DataTable account)
	{
		firstName.sendKeys(account.row(1).get(0));
		lastName.sendKeys(account.row(1).get(1));
		email.sendKeys(account.row(1).get(2));
		password.sendKeys(account.row(1).get(3));
		passwordConfirmation.sendKeys(account.row(1).get(4));
		
		createAccount.click();
	}
	
	public void wasTheAccountCreated()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.message-success div")));
		
		Assert.assertEquals(successMessage.getText(), "Thank you for registering with Main Website Store.");
	}
}
