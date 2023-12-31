package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ItemsSteps {
	
	private Browser browser;
	
	public ItemsSteps(Browser browser)
	{
		this.browser = browser;
	}
	
	@When("I click on {string} product")
	public void clickOnProduct( String product )
	{
		browser.items.clickOnProduct(product);
	}

	/* LUMA-1 | LUMA-2 */
	@Then("I validate I am in the {string} page")
	public void validateIAmInThePage(String page) 
	{
		  browser.items.IsUserInThePage(page);
	}
	
	/* LUMA-3 */
	@Then("I validate the {string} is displayed in the page")
	public void validateTheItemIsDisplayedInThePage(String item)
	{
		browser.items.isItemDisplayedInThePage(item);
	}
	
	/* LUMA-7 */
	@Then("I validate the {string} message gets displayed")
	public void validateTheNoResultsMessageGetsDisplayed(String message)
	{
		browser.items.isNoSearchMessageDisplayed(message);
	}
}
