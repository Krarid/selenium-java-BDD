package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Screenshot;

public class ProductSteps {
	
	private Browser browser;
	
	public ProductSteps(Browser browser)
	{
		this.browser = browser;
	}
  
	@And("I buy {string} units of {string} size and {string} color")
	public void buyUnitsOfSizeAndColor(String units, String size, String color)
	{
		browser.product.selectSize(size);
		browser.product.selectColor(color);
		browser.product.addQuantity(units);
		browser.product.addToCart();
		browser.product.clickOnCart();
		browser.product.proceedToCheckout();
	}
	
	@And("I buy {string} units")
	public void buyUnits(String units) throws Exception
	{
		try {
			browser.product.addQuantity(units);
			browser.product.addToCart();
			browser.product.clickOnCart();
			browser.product.proceedToCheckout();
		} catch( Exception e ) {
			System.err.print("Exception ocurred: " + e);
			Screenshot.takeScreenshot(browser.driver, "LUMA-10.png" );
			
			throw e;
		}
	}
	
	@When("I click on cart")
	public void clickOnCart()
	{
		browser.product.clickOnCart();
	}
	
	@Then("I validate there are no items in the shipping cart")
	public void areThereItemsInTheShippingCart()
	{
		browser.product.areThereItemsInTheShippingCart();
	}
}
