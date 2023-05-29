Feature: My feature
  Background:
    Given User launches a browser and navigates to the  webPage
    When  user enters Username and Password and clicks on the login button

  @run1
  Scenario: Bookstore Purchase Chrome
    When user search for Book
    When  user logs out

  @run2
  Scenario: Bookstore Purchase Firefox
    When user search for Book
    When  user logs out
  @run3
  Scenario: Bookstore Purchase Edge
    When user search for Book
    When  user logs out
