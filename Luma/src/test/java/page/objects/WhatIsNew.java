package page.objects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatIsNew {

	private HashMap<String, Integer> newInWomenMap = new HashMap<String, Integer>();
	private HashMap<String, Integer> newInMenMap = new HashMap<String, Integer>();
	
	@FindBy(css = "div.categories-menu ul.items:nth-child(2) li.item a")
	@CacheLookup
	private List<WebElement> newInWomen;
	
	@FindBy(css = "div.categories-menu ul.items:nth-child(4) li.item a")
	@CacheLookup
	private List<WebElement> newInMen;
	
	private WebDriver driver;
	
	public WhatIsNew(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		newInWomenMap.put("Hoodies & Sweatshirts", 0);
		newInWomenMap.put("Jackets", 1);
		newInWomenMap.put("Tees", 2);
		newInWomenMap.put("Bras & Tanks", 3);
		newInWomenMap.put("Pants", 4);
		newInWomenMap.put("Shorts", 5);
		
		newInMenMap.put("Hoodies & Sweatshirts", 0);
		newInMenMap.put("Jackets", 1);
		newInMenMap.put("Tees", 2);
		newInMenMap.put("Tanks", 3);
		newInMenMap.put("Pants", 4);
		newInMenMap.put("Shorts", 5);
	}
	
	public void clickOnSection( String section )
	{
		newInWomen.get(newInWomenMap.get(section)).click();
	}
}
