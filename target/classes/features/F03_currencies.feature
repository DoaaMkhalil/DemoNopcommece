Feature: Verifying currency of product price

  Scenario Outline: Verify that all product price appear with correct currency
    Given user selects currency from the dropdown list on the top left of home page "<Currency>"
    Then all product price appear with correct currency
    Examples:
      | Currency |
       |US Dollar|
         |Euro|
