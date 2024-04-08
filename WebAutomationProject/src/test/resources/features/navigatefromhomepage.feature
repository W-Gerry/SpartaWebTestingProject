Feature: As a user, I want to be able to navigate from the Luma homepage to other pages

  Background:
    Given I am on the Luma website
    And I have accepted the cookie policy

  Scenario: Navigate to the What's New page
    When I navigate to the What's New page
    Then I should see the What's New page

  Scenario: Navigate to the Women page
    When I navigate to the Women page
    Then I should see the Women page

  Scenario: Navigate to the Men page
    When I navigate to the Men page
    Then I should see the Men page

  Scenario: Navigate to the Gear page
    When I navigate to the Gear page
    Then I should see the Gear page

  Scenario: Navigate to the Training page
    When I navigate to the Training page
    Then I should see the Training page

  Scenario: Navigate to the Sale page
    When I navigate to the Sale page
    Then I should see the Sale page

