Feature: Adding Items to the Cart on eshop.vodafone.com.eg

  Background:
    Given I am on the eshop vodafone homepage
    And I log in with valid credentials

  Scenario: Select 2 items from the product listings and add to the cart
    When I select the first item, navigate to its product page, and add it to the cart
    And I select the second item, navigate to its product page, and add it to the cart
    Then the items should be in the cart

  Scenario: Search for a specific item and add it to the cart
    When I search for a specific item, navigate to its product page, and add it to the cart
    Then the item should be in the cart
