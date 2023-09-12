package steps;

import io.cucumber.java.en.And;

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
	public void buyUnits(String units)
	{
		browser.product.addQuantity(units);
		browser.product.addToCart();
		browser.product.clickOnCart();
		browser.product.proceedToCheckout();
	}
}
