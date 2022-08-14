Feature: Login feature

  Scenario: Valid admin login
    Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in


  Scenario: Valid ess login
    Given user is navigated to HRMS application
    When user enters ess username and password
    And user clicks on login button
    Then ess user is successfully logged in

  Scenario: Invalid login
    Given user is navigated to HRMS application
    When user enter invalid username and password
    And user clicks on login button
    Then user is able to see error message