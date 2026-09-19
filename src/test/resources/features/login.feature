Feature: Login

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters username "student" and password "Password123"
    Then the Logged In Successfully displayed