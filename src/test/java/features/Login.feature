Feature: Login User

  @sl_1 @SmokeTest @RegressionTest @UatTest
  Scenario Outline: Successful Login with Valid Credentials
    Given User is at the SauceDemo LogIn page
    When User enter the login credentials as "<UserName>" and "<Password>"
    And Click on the Log in button
    Then Successful LogIn message should display

    Examples:
      | UserName      | Password     |
      | standard_user | secret_sauce |

  @sl_2 @SmokeTest @RegressionTest @UatTest
  Scenario Outline: Add products to cart and proceed checkout
    Given User is on the Inventory page
    When User add two products to cart "<product1>" and "<product2>"
    And Click on the bucket symbol at the right corner
    Then Click on checkout to navigate to checkout page

    Examples:
      | product1                        | product2                          |
      | add-to-cart-sauce-labs-backpack | add-to-cart-sauce-labs-bike-light |

  @sl_3 @SmokeTest @RegressionTest @UatTest
  Scenario Outline: Proceed payment and place order
    Given User is on the checkout page
    When User enter details "<firstName>" "<lastName>" and "<pinCode>" click on Continue button
    And User check the bill details and Finish the transaction
    Then User see Thank You message for order completion

    Examples:
      | firstName | lastName | pinCode |
      | Vijay     | Sonawane | 411023  |
