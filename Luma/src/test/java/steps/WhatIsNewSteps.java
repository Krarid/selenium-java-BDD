package steps;

import io.cucumber.java.en.Given;

public class WhatIsNewSteps {
	
	private Browser browser;
	
	public WhatIsNewSteps(Browser browser)
	{
		this.browser = browser;
	}
	
	@Given("I click on {string} section")
  	public void clickOnSection(String section) {
		browser.whatIsNew.clickOnSection(section);
	}
}
