Feature: Verify subcategories is displayed when user hover on category name
  Scenario Outline: subcategories is displayed when user hover on category name
    Given user hovers on category name
    When  he select subcategory
    Then page name the same of subcategory
    Examples:
      |1  |
      |       2|
    |        3|
    |         |

