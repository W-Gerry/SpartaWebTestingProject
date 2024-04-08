Feature: As a user, I want to be able to navigate from pages to the Luma homepage.

  Scenario: Navigate to the Luma homepage from the What's New page
    Given I am on the What's New page
    And I have accepted the cookie policy
    When I click on the Luma logo
    Then I should be taken to the Luma homepage

  Scenario: Navigate to the Luma homepage from the Women's shop page
    Given I am on the Women's shop page
    And I have accepted the cookie policy
    When I click on the Luma logo
    Then I should be taken to the Luma homepage

  Scenario: Navigate to the Luma homepage from the Men's shop page
    Given I am on the Men's shop page
    And I have accepted the cookie policy
    When I click on the Luma logo
    Then I should be taken to the Luma homepage

  Scenario: Navigate to the Luma homepage from the Gear shop page
    Given I am on the Gear shop page
    And I have accepted the cookie policy
    When I click on the Luma logo
    Then I should be taken to the Luma homepage

  Scenario: Navigate to the Luma homepage from the Training shop page
    Given I am on the Training shop page
    And I have accepted the cookie policy
    When I click on the Luma logo
    Then I should be taken to the Luma homepage

  Scenario: Navigate to the Luma homepage from the Sale shop page
    Given I am on the Sale shop page
    And I have accepted the cookie policy
    When I click on the Luma logo
    Then I should be taken to the Luma homepage


