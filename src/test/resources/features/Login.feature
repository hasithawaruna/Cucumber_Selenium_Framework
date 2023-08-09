Feature: Login Functionality For AddressManager Website

  As a user of the AddressManager website
  I want to be able to log in with given account
  So that I can access my address details


  Scenario Outline: Verify user can login successfully with valid credentials
    Given I entered a valid "<username>" and a "<password>"
    When I click on the login button
    Then I should be able logged in successfully

    Examples:
      | username  | password  |
      | admin     | admin@123 |