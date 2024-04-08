Feature: As a user, I want to be able to login to the Luma store

  Scenario: User cannot login with a set of invalid login credentials
    Given The user is on the Luma store login page
    And I have clicked the consent button login
    When The user enters invalid username "invalid_username" and invalid password "invalid_password"
    And The user clicks the login button
    Then An error message "Invalid username or password" should be displayed
    And The user remains on the login page

  Scenario: User can log in with a set of valid login credentials
    Given The user is on the Luma store login page
    And I have clicked the consent button login
    When The user enters valid username "valid_username" and valid password "valid_password"
    And The user clicks the login button
    Then The user should be redirected to the Luma store homepage
