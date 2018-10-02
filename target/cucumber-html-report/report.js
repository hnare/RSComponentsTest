$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/GuestCheckout.feature");
formatter.feature({
  "line": 2,
  "name": "Online ckeckout",
  "description": "As a guest customer \r\nI want to buy the products online\r\nSo that I can get the products delivered",
  "id": "online-ckeckout",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@endToEnd"
    }
  ]
});
formatter.before({
  "duration": 2987415562,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Registered Customer Checkout",
  "description": "",
  "id": "online-ckeckout;registered-customer-checkout",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@loggedInUserCheckout"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "I am on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "I have logged with username as \"hnare\" and password \"Mpl1003496\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I add the product \"1445337\" to my basket",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I am navigated to basket page",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I proceed to checkout",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I submit delivery details",
  "rows": [
    {
      "cells": [
        "companyName",
        "addressLine1",
        "town",
        "postcode"
      ],
      "line": 31
    },
    {
      "cells": [
        "test company",
        "62 Robinson Way",
        "Northampton",
        "NN4 6FJ"
      ],
      "line": 32
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "I am navigated to payment details page",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "I submit my payment details // Steps not implemented",
  "rows": [
    {
      "cells": [
        "cardNumber",
        "cardHolderName",
        "expiry",
        "cvv",
        "cardName"
      ],
      "line": 35
    },
    {
      "cells": [
        "4111111111111111",
        "Himani Nare",
        "02/2020",
        "111",
        "My Card"
      ],
      "line": 36
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "I am naviagted to Confirm payment page  // Steps not implemented",
  "keyword": "And "
});
formatter.match({
  "location": "BrowserUtils.I_am_on_the_home_page()"
});
formatter.result({
  "duration": 8410050382,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hnare",
      "offset": 32
    },
    {
      "val": "Mpl1003496",
      "offset": 53
    }
  ],
  "location": "BrowserUtils.I_have_logged_with_username_and_password(String,String)"
});
formatter.result({
  "duration": 3616564347,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1445337",
      "offset": 19
    }
  ],
  "location": "BrowserUtils.I_have_added_the_product_to_my_basket(String)"
});
formatter.result({
  "duration": 10569107420,
  "status": "passed"
});
formatter.match({
  "location": "BrowserUtils.I_am_navigated_to_basket_page()"
});
formatter.result({
  "duration": 110738633,
  "status": "passed"
});
formatter.match({
  "location": "BrowserUtils.I_proceed_to_checkout()"
});
formatter.result({
  "duration": 1754494309,
  "status": "passed"
});
formatter.match({
  "location": "BrowserUtils.I_submit_delivery_details(Customer\u003e)"
});
formatter.result({
  "duration": 2312324439,
  "status": "passed"
});
formatter.match({
  "location": "BrowserUtils.I_am_navigated_to_payment_details_page()"
});
formatter.result({
  "duration": 46610375,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "duration": 589978852,
  "status": "passed"
});
});