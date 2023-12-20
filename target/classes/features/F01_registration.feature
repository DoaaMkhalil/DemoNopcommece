Feature: Validation of registration feature
  Background:
    Given guest user opens register page
  @smoke
  Scenario Outline: check that guest user can create new account when he enter valid data
    When user selects the gender "<gender>"
    And enters firstrname & lastname
    And  chooses DOB
    And enter a valid Email
    And enters pass & confirmation pass
    And press on register
    Then new account is created successfully
    Examples:
    |  gender   |
    |    male   |
    |  female   |
  Scenario: check that guest user can not create new account when he enter invalid email
    When user selects the gender "<male>"
    And enters firstrname & lastname
    And  chooses DOB
    And enter a invalid Email "<doaamohamed.com>"
    And enters pass & confirmation pass
    And press on register
    Then  error msg is displayed


