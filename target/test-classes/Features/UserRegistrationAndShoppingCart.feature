Feature: User Registration and Shopping Cart Test

  Scenario: Register, Add Product to Cart, and Validate Payment
    Given I am on the website homepage
    When I click on Sign in on the landing page and Register button
    And I create an account with a random email address and personal information
    And I click on the Continue button
    Then I should see my correct name and surname displayed on the landing screen
    When I add a product to the cart
    And I proceed to the checkout page
    And I continue until the payment page
    Then I should see that the product details are correct on the payments page