Feature: Add New Record To AddressManager Website

  As a logged user of the AddressManager website
  I want to add a new record to the system
  So that I can see newly added record in the table

  Background:
    Given I enter a valid username "admin" and a password "admin@123"
    When I click on the login button
    Then I should be able logged in successfully

  Scenario Outline: Verify user can add a new record
    When I click on Add New button
    And I entered a name "<name>"
    And I entered a age "<age>"
    And I entered a address "<address>"
    And I select a birthday "<birthday>"
    And I select a country "<country>"
    And I select a expertise "<expertise>"
    And I select gender "<gender>"
    And I click on submit
    Then I should be able to see new record with "<name>" value

    Examples:
      | name  | age  |address  |birthday  |country  |expertise  |gender  |
      | Jack Ryan | 25   | 6th Lane, Colombo | 2015-Mar-18| Sri Lanka | GIT    | MALE  |

  Scenario Outline: Verify the address field is mandatory
    When I click on Add New button
    And I entered a name "<name>"
    And I entered a age "<age>"
    And I select a birthday "<birthday>"
    And I select a country "<country>"
    And I select a expertise "<expertise>"
    And I select gender "<gender>"
    And I click on submit
    Then I should be able to see Address field is mandatory

    Examples:
      | name  | age   |birthday  |country  |expertise  |gender  |
      | John Phillip | 25   | 2014-Aug-18| Sri Lanka | HTML    | MALE  |

  Scenario Outline: Verify user can clear the form data
    When I click on Add New button
    And I entered a name "<name>"
    And I entered a age "<age>"
    And I entered a address "<address>"
    And I select a birthday "<birthday>"
    And I select a country "<country>"
    And I select a expertise "<expertise>"
    And I select gender "<gender>"
    When I click on reset button
    Then All filled values should erase successfully

    Examples:
      | name  | age  |address  |birthday  |country  |expertise  |gender  |
      | Matte jason | 25   | 6th Lane, Colombo | 2019-Feb-28| Sri Lanka | JAVA | FEMALE  |