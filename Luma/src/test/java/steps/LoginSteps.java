package steps;

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
}
