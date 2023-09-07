package steps;

import io.cucumber.java.en.Then;

public class ItemsSteps {
	
	private Browser browser;
	
	public ItemsSteps(Browser browser)
	{
		this.browser = browser;
	}

	@Then("I validate I am in the {string} page")
	public void validateIAmInThePage(String page) 
	{
		  browser.items.IsUserInThePage(page);
	}
}
