package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private Browser browser;
	
	public LoginSteps(Browser browser)
	{
		this.browser = browser;
	}
	
	@When("I enter {string} and {string} as my credentials")
	public void enterMyCredentials(String username, String password)
	{
		browser.login.enterCredentials(username, password);
	}
	
	@Then("I validate an error message is displayed")
	public void validateAnErrorMessageIsDisplayed()
	{
		browser.login.isLoginErrorMessageDisplayed();
	}
}
