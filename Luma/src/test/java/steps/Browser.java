package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import page.objects.*;

public class Browser {
	
	protected WebDriver driver;
	protected Home home;
	protected Product product;
	protected WhatIsNew whatIsNew;
	protected Items items;
	protected Checkout checkout;
	protected Login login;
	protected CreateAccount createAccount;
	
	public Browser()
	{
		driver = new ChromeDriver();
		home = new Home(driver);
		product = new Product(driver);
		whatIsNew = new WhatIsNew(driver);
		items = new Items(driver);
		checkout = new Checkout(driver);
		login = new Login(driver);
		createAccount = new CreateAccount(driver);
	}
	
	@After
	public void tearDown() throws Exception 
	{
		driver.quit();
	}
}