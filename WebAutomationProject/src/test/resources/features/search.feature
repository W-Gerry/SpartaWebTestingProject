Feature: Product Search Functionality

  As a user, I want to be able to search for products on the website.

  Background:
    Given I am on the Magento Software Testing Board website

  Scenario: Search for items that are available
    When I search for available items
    Then I should see a list of available items

  Scenario: Search for items that are not available
    When I search for unavailable items
    Then I should see a message indicating no items found

  Scenario: Search for items by price range
    When I search for items within a specific price range
    Then I should see only items within that price range
