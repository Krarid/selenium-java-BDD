@selenium
Feature: Luma

  @smoke
  Scenario: Add item to cart
    Given I visit Luma page
    When I add Hero Hoodie to the cart
    Then I validate the Hero Hoodie was added to the cart