@endToEnd
Feature: Online ckeckout
  As a guest customer 
  I want to buy the products online
  So that I can get the products delivered 

  @guestCheckout
  Scenario: Guest Checkout 
    Given I am on home page
    And I add the product "1445337" to my basket
    And I am navigated to basket page
    And I proceed to checkout as guest
    When I submit my delivery details
    |Title|firstName|surName|mobile     |companyName |addressLine1   |town        |postcode|
    |Mrs.  |Himani   |Nare   |09987544345|test company|62 Robinson Way|Northampton|NN4 6FJ |
    And I am navigated to payment details page
    When I submit my payment details // Steps not implemented
    |cardNumber      |cardHolderName|expiry  |cvv  |cardName |
    |4111111111111111|Himani Nare   |02/2020 |111  |My Card  |
    And I am naviagted to Confirm payment page // Steps not implemented
    
    
   @loggedInUserCheckout
  Scenario: Registered Customer Checkout 
    Given I am on home page
    And I have logged with username as "hnare" and password "Mpl1003496"
    And I add the product "1445337" to my basket
    And I am navigated to basket page
    And I proceed to checkout
    And I submit delivery details
    |companyName |addressLine1   |town       |postcode|
    |test company|62 Robinson Way|Northampton|NN4 6FJ |
    And I am navigated to payment details page
    When I submit my payment details // Steps not implemented
    |cardNumber      |cardHolderName|expiry  |cvv  |cardName |
    |4111111111111111|Himani Nare   |02/2020 |111  |My Card  |
    And I am naviagted to Confirm payment page  // Steps not implemented
    
