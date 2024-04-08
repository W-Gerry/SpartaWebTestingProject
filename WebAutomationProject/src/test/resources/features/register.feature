Feature: As a user, I want to be able to create an account for the website

  Scenario: User signs up to the website with valid credentials
    Given I am on the create account page
    And I have clicked the consent button
    When I enter all valid "tester", "Testing", "testertting12312313@testing.com" and "Tester123"
    Then My Account should be successfully created

  Scenario Outline: User signs up to the website without valid credential
    Given I am on the create account page
    And I have clicked the consent button
    When I enter "<firstName>", "<lastName>", "<email>", "<password>" and click enter
    Then I will see the message "<message>"
    Examples:
      | firstName | lastName | email | password | message |
      | !!! | Dylan | Bob.Dylan@hotmail.com | TestPass1 | Please enter a valid first name |
      | Bob | !!! | Bob.Dylan@hotmail.com | TestPass1 | Please enter a valid last name |
      | Bob | Dylan | Bob.Dylan | TestPass1 | Please enter a valid email address |
      | Bob | Dylan | Bob.Dylan@hotmail.com | 123123 | Minimum length of this field must be equal or greater than 8 |
      | Bob | Dylan | Bob.Dylan@hotmail.com | testtest | Minimum of different classes of characters in password is 3 |

