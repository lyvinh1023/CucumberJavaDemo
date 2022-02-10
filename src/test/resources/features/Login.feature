# Author: Vinh Ly
Feature: feature to test login functionality

  Background: 
    Given user is on login page

  @smoke
  Scenario Outline: Check login successfully with valid credentials
    When user enters <username> and <password>
    And user clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username | password |
      | user1    |    12345 |
      | user2    |    12345 |

  @regression
  Scenario Outline: Check login fails with invalid credentials
    When user enters <username> and <password>
    And user clicks on login button
    Then the password invalid error displays

    Examples: 
      | username | password |
      | user1    | abc      |
      | user2    |      123 |
