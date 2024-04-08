Feature: As a User, I want to add items to my basket and process the purchase

  Scenario: Adding item to basket with valid product information selected
    Given I am on a Product page
    And I have clicked the consent button
    And I have selected a size
    And I have selected a colour
    And I have selected a valid quantity
    When I click on to add to basket
    Then The product will be added to my basket
