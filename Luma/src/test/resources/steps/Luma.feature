@LUMA
Feature: Luma

	Background:
		Given I visit Luma page

  @LUMA-1
  Scenario Outline: Sections from New in Womens can be opened
    Given I click on What is New
    When I click on "<section>" women section
    Then I validate I am in the "<section>" page
    
    Examples:
    | section								|
    |	Hoodies & Sweatshirts	|
    | Bras & Tanks					|
    
  @LUMA-2
  Scenario Outline: Sections from New in Mens can be opened
    Given I click on What is New
    When I click on "<section>" men section
    Then I validate I am in the "<section>" page
    
    Examples:
    | section								|
    |	Hoodies & Sweatshirts	|
    | Tanks									|
    
	@LUMA-3
	Scenario Outline: Women tops can be searched
		Given I search "<item>" item
		When I click on search autocomplete 
		Then I validate the "<item>" is displayed in the page
		
		Examples:
		| item								|
		| Jade Yoga Jacket		|
		| Diva Gym Tee				|
		
	@LUMA-4
	Scenario Outline: Women bottoms can be searched
		Given I search "<item>" item
		When I click on search autocomplete 
		Then I validate the "<item>" is displayed in the page
		
		Examples:
		| item									|
		| Portia Capri					|
		| Artemis Running Short	|
		
	@LUMA-5
	Scenario Outline: Men tops can be searched
		Given I search "<item>" item
		When I click on search autocomplete 
		Then I validate the "<item>" is displayed in the page
		
		Examples:
		| item									|
		| Typhon Performance		|
		| Logan HeatTec					|
		
	@LUMA-6
	Scenario Outline: Men bottoms can be searched
		Given I search "<item>" item
		When I click on search autocomplete 
		Then I validate the "<item>" is displayed in the page
		
		Examples:
		| item			|
		| Livingston|
		| Kratos		|
		
	@LUMA-7
	Scenario Outline: No items are displayed when searching non-existing items
		Given I search "<item>" item
		When I hit Enter button
		Then I validate the "Your search returned no results." message gets displayed
		
	Examples:
	| item			|
	|	QWERTY		|
	 
	@LUMA-8
	Scenario Outline: Women accessories can be purchased
		Given I go to "<header>" > "<section>" > "<item>"
		When I click on "<product>" product
		And I buy "<units>" units of "<size>" size and "<color>" color
		And I fill the shipping details with following data
		|	Email					|	First name	|	Last name	|	Street	|	City		|	State		|	ZIP			|	Country		|	Phone number	|	Shipping method	|
		|	hola@test.com	|	Test				|	Test			|	Test		|	Test		|	Berlin	|	12345		|	Germany		|	12345678			|	Fixed						|
		Then I validate the order was successful
		
	Examples:
	|	header	|	section	|	item		|	product						|	units	|	size	|	color	|
	|	Women		|	Tops		|	Jackets	|	Jade Yoga Jacket	|	1			|	M			|	green	|
	|	Women		|	Bottoms	|	Pants		|	Portia Capri			|	20		|	29		|	blue	|
	
	@LUMA-9
	Scenario Outline: Men accessories can be purchased
		Given I go to "<header>" > "<section>" > "<item>"
		When I click on "<product>" product
		And I buy "<units>" units of "<size>" size and "<color>" color
		And I fill the shipping details with following data
		|	Email					|	First name	|	Last name	|	Street	|	City		|	State		|	ZIP			|	Country		|	Phone number	|	Shipping method	|
		|	hola@test.com	|	Test				|	Test			|	Test		|	Test		|	Berlin	|	12345		|	Germany		|	12345678			|	Fixed						|
		Then I validate the order was successful
		
	Examples:
	|	header	|	section	|	item		|	product							|	units	|	size	|	color	|
	|	Men			|	Tops		|	Jackets	|	Typhon Performance	|	1			|	M			|	red		|
	|	Men			|	Bottoms	|	Pants		|	Livingston					|	99		|	34		|	black	|
	
	@LUMA-10
	Scenario Outline: Gear accessories can be purchased
		Given I go to "<header>" > "<section>"
		When I click on "<product>" product
		And I buy "<units>" units
		And I fill the shipping details with following data
		|	Email					|	First name	|	Last name	|	Street	|	City		|	State		|	ZIP			|	Country		|	Phone number	|	Shipping method	|
		|	hola@test.com	|	Test				|	Test			|	Test		|	Test		|	Berlin	|	12345		|	Germany		|	12345678			|	Fixed						|
		Then I validate the order was successful
		
	Examples:
	|	header	|	section	|	product							|	units	|
	|	Gear		|	Bags		|	Fusion Backpack			|	1			|
	
	@LUMA-11
	Scenario: Validate message when there are no items in the shopping cart
	When I click on cart
	Then I validate there are no items in the shipping cart
	
	@LUMA-12
	Scenario Outline: User can sign in
	Given I go to login page
	When I enter "<username>" and "<password>" as my credentials
	Then I validate I was logged in
	
	Examples:
	|	username							|	password		|
	| vohola2224@sesxe.com	|	Test123@QA$	|
	
	@LUMA-13
	Scenario: User can create an account
	Given I go to create an account
	When I fill the account details
	| First Name	|	Last Name	|	Email									|	Password		|	Confirm password	|
	|	Test				|	Test			|	@sesxe.com	|	Test123@QA$	|	Test123@QA$				|
	Then I validate my account was created
	
	@LUMA-14
	Scenario Outline: User cannot sign in with incorrect credentials
	Given I go to login page
	When I enter "<username>" and "<password>" as my credentials
	Then I validate an error message is displayed
	
		Examples:
	|	username										|	password		|
	| nonexistingaccount@test.com	|	Test123@QA$	|