package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CheckoutSteps {
	
	private Browser browser;
	
	public CheckoutSteps(Browser browser)
	{
		this.browser = browser;
	}
	
	@And("I fill the shipping details with following data")
	public void fillShippingDetails( DataTable details )
	{
		browser.checkout.fillShippingAddress(details);
		browser.checkout.next();
		browser.checkout.placeOrder();
	}
	
	@Then("I validate the order was successful")
	public void validateTheOrderWasSuccessful()
	{
		browser.checkout.wasTheOrderSuccessful();
	}
}
