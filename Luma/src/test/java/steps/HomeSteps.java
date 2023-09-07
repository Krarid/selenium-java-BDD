package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class HomeSteps {
	
	private Browser browser;
	
	public HomeSteps(Browser browser)
	{
		this.browser = browser;
	}
	
	@Given("I visit Luma page")
	public void visitLumaPage() {
		browser.home.visitLuma();
	}
	
	@Given("I click on What is New")
	public void clickOnWhatIsNew()
	{
		browser.home.clickOnWhatIsNew();
	}
	
	@When("I add Hero Hoodie to the cart")
	public void addItemToTheCart() {
		browser.product.selectSize(3);
		browser.product.selectColor(2);
		browser.product.addToCart();
	}
	
	@Then("I validate the Hero Hoodie was added to the cart")
	public void validateTheItemWasAddedToTheCart() {
		browser.product.isItemInTheCart();
	}
	
	@After
	public void tearDown() throws Exception 
	{
		browser.driver.quit();
	}
}
