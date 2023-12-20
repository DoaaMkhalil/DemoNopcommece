Feature: Verify search feature
  Scenario Outline: user could search using product name
        Given user search "<keyword>"
        When press on search button
        Then correct products appears
    Examples:
      | keyword |
      | book |
      |laptop|
      | nike |

  Scenario Outline: user could search for product using sku
    Given user search "<sku>"
    When press on search button
    Then  product appears contain SKU
    Examples:
           |sku|
      | SCI_FAITH |
     | APPLE_CAM |
     | SF_PRO_11 |