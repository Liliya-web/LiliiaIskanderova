Feature: Ex1

  Scenario: Select items on Service -> Different Elements Page
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on Different Elements Page in Header
    And I select Water checkbox
    And I select Wind checkbox
    And I select Selen radio
    And I select Yellow in dropdown
    Then log row for Water checkbox is displayed and it's condition changed to true
    And log row for Wind checkbox is displayed and it's condition changed to true
    And log row for Selen radio is displayed and it's condition changed to true
    And log row for Yellow color in dropdown is displayed and it's condition changed to true
