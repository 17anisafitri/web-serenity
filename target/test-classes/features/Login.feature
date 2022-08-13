@Login
Feature: User be able to Login

  Background:
    Given I am on the login page

  @Normal-User #tagname
  Scenario Outline: As user I have be able to success login

  When I input "<username>" username
  And I input valid password
  And I click Login button
  Then I am on the home page

    Examples:
    |username|
    |standard_user|
    |problem_user|

  @Locked-User
  Scenario: As user, I have been locked out

    When I input locked username
    And I input valid password
    And I click Login button
    Then I can see error message "Epic sadface: Sorry, this user has been locked out."