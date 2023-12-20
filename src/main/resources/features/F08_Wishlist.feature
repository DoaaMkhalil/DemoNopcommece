Feature: verify wishlist functionality
  Scenario: verify That the product is added successfully to wishlist
  Given user adds product to wishlist
 Then product is added to wishlist successfully

  Scenario: verify That the wishlist contains product
    Given user adds product to wishlist
    And open wishlist page
    Then wishlist contain product