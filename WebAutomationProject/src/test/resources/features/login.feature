Feature: As a user, I want to be able to login to the Luma store

  Scenario: User cannot login with a set of invalid login credentials
    Given the user is on the Luma store login page
    When the user enters invalid username "invalid_username" and invalid password "invalid_password"
    And the user clicks the login button
    Then an error message "Invalid username or password" should be displayed
    And the user remains on the login page

  Scenario: User can log in with a set of valid login credentials
    Given the user is on the Luma store login page
    When the user enters valid username "valid_username" and valid password "valid_password"
    And the user clicks the login button
    Then the user should be redirected to the Luma store homepage
