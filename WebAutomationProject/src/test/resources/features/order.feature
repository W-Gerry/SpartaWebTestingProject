Feature: As a User, I want to add items to my basket and process the purchase

 Scenario: Adding item to basket with valid product information selected
    Given I am on a Product page
    And I have clicked the consent button
    And I have selected a size
    And I have selected a colour
    And I have selected a quantity
    When I click on to add to basket
   Then I will see the success message

  Scenario: Adding item to basket with no size selected
    Given I am on a Product page
    And I have clicked the consent button
    And I have not selected a size
    And I have selected a colour
    And I have selected a quantity
    When I click on to add to basket
    Then I will see the size failure message

  Scenario: Adding item to basket with no colour selected
    Given I am on a Product page
    And I have clicked the consent button
    And I have selected a size
    And I have not selected a colour
    And I have selected a quantity
    When I click on to add to basket
    Then I will see the colour failure message

  Scenario: Adding item to basket with 0 quantity selected
    Given I am on a Product page
    And I have clicked the consent button
    And I have selected a size
    And I have selected a colour
    And I have selected a quantity of zero
    When I click on to add to basket
    Then I will see the zero quantity failure message

  Scenario: Adding item to basket with empty quantity selected
    Given I am on a Product page
    And I have clicked the consent button
    And I have selected a size
    And I have not selected a colour
    And I have not selected a quantity
    When I click on to add to basket
    Then I will see the empty quantity failure message
