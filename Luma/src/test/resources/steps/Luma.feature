@Smoke
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
    | Jackets								|
    | Tees									|
    | Bras & Tanks					|
    | Pants									|
    | Shorts								|
    
  @LUMA-2
  Scenario Outline: Sections from New in Mens can be opened
    Given I click on What is New
    When I click on "<section>" men section
    Then I validate I am in the "<section>" page
    
    Examples:
    | section								|
    |	Hoodies & Sweatshirts	|
    | Jackets								|
    | Tees									|
    | Tanks									|
    | Pants									|
    | Shorts								|