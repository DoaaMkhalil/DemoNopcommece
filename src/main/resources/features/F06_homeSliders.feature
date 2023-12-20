Feature: validation of home slider
  Scenario Outline: Validate that sliders is clickable
    Given  user click on the slider "<slider>"
    Then  corresponding page is open
    Examples:
      | slider |
      |  glaxy  |
     |  iphone   |

