package steps;

import io.cucumber.java.en.Given;

public class WhatIsNewSteps {
	
	private Browser browser;
	
	public WhatIsNewSteps(Browser browser)
	{
		this.browser = browser;
	}
	
	@Given("I click on {string} women section")
  	public void clickOnWomenSection(String section) {
		browser.whatIsNew.clickOnWomenSection(section);
	}
	
	@Given("I click on {string} men section")
  	public void clickOnMenSection(String section) {
		browser.whatIsNew.clickOnMenSection(section);
	}
}
