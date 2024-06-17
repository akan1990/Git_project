@tag
Feature: Purchase the Order from Ecommerce Website
  I want to use this template for my feature file

  Background: 
    Given: I landed on Ecommerce Webpage


  @tag2
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <username>  and password <password>
    When I add Product <productName> to cart
    And Checkout <productName> and Submit the Order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | username                    | password  | productName |
      | akankshasadaphal4@gmail.com | Akan@1990 | ZARA COAT 3 |
