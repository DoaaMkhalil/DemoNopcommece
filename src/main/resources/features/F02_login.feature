Feature:  Verify Login Functionality

    Scenario: User can access his account when he enters valid UserName and Valid Password
      Given User opens login page
      When User enters valid UserName
      And User enters Valid Password
      And press on Login button
      Then user access his account successfully

  Scenario: User can not access an account with invalid credential
    Given User opens login page
    When User enters invalid Email "doaa@gmail.com"
    And User enters any password
    And press on Login button
    Then user can not access the account

  Scenario: User can not access an account with valid Email invalid password
    Given User opens login page
    When User enters valid UserName
    And User enters any password
    And press on Login button
    Then user can not access the account