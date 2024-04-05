Feature: As a user, I want to be able to create an account for the website

  Scenario: User signs up to the website with valid credentials
    Given I am on the create account page
    When I enter all valid "tester", "Testing", "testertting12312313@testing.com" and "Tester123"
    Then My Account should be successfully created