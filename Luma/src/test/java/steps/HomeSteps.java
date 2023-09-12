package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomeSteps {
	
	private Browser browser;
	
	public HomeSteps(Browser browser)
	{
		this.browser = browser;
	}
	
	/* PRECONDITION */
	@Given("I visit Luma page")
	public void visitLumaPage() {
		browser.home.visitLuma();
	}
	
	/* LUMA-1 | LUMA-2 */
	@Given("I click on What is New")
	public void clickOnWhatIsNew()
	{
		browser.home.clickOnWhatIsNew();
	}
	
	/* LUMA-3 */
	@Given("I search {string} item")
	public void searchItem(String item)
	{
		browser.home.searchItem(item);
	}
	
	/* LUMA-8 */
	@Given("I go to {string} > {string} > {string}")
	public void goToItem(String header, String section, String items)
	{
		browser.home.goToHeader(header);
		browser.home.goToSection(section);
		browser.home.goToItem(items);
		browser.home.clickOnReference();
	}
	
	@When("I click on search autocomplete")
	public void clickOnAutocomplete()
	{
		browser.home.clickOnAutocomplete();
	}
	
	@When("I hit Enter button")
	public void hitEnterButton()
	{
		browser.home.hitEnterButton();
	}
	
	@After
	public void tearDown() throws Exception 
	{
		browser.driver.quit();
	}
}
