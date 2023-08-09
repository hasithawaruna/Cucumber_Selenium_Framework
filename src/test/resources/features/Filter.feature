Feature: Filter Functionality For AddressManager Website

  As a logged user of the AddressManager website
  I want to filter records by given values
  So that I can see specific set of records

  Background:
    //Given I am on the AddressManager login page
    Given I enter a valid username "admin" and a password "admin@123"
    When I click on the login button
    Then I should be able logged in successfully


  Scenario Outline: Verify user can filter by button successfully
    Given I entered a "<lastName>" to the Filter Full Name input field
    When I click on the Filter button
    Then I should be able to see results which contain "<lastName>" value

    Examples:
      | lastName  |
      | Buck     |

  Scenario Outline: Verify user can filter by table header successfully
    When I entered a "<lastName>" to the input box of Full Name table header
    Then I should be able to see results which contain "<lastName>" value

    Examples:
      | lastName  |
      | Buck     |