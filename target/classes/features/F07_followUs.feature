Feature: validation of contactUS module
Scenario Outline: validation of contactUS ways
  Given user click on "<window>" icon
  When user navigate to second tab
Then correct contactUS page is opend "<URL>"
  And user close the second window
  Examples:
    |URL  | |window |
   |   https://www.facebook.com/nopCommerce  | |   Facebook    |
  |  https://twitter.com/nopCommerce   | |   Twitter    |
  |https://demo.nopcommerce.com/new-online-store-is-open     | |   RSS    |
  |  https://www.youtube.com/user/nopCommerce   | |  YouTube     |