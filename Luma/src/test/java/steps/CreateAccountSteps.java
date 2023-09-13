package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountSteps {
	
	private Browser browser;
	
	public CreateAccountSteps(Browser browser)
	{
		this.browser = browser;
	}
	
	@When("I fill the account details")
	public void fillTheAccountDetails(DataTable account)
	{
		browser.createAccount.fillAccountDetails(account);
	}
	
	@Then("I validate my account was created")
	public void validateMyAccountWasCreated()
	{
		browser.createAccount.wasTheAccountCreated();
	}
}
