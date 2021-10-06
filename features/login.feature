# this should happen before writing testing methods. have very specific scenarios, they describe a "path" taken by the end user (aka 'actor'). 

Feature: Login for Swag Labs
  
  Background:
    Given a user is on the home page of Swag Labs
    
  Scenario: Logging into Swag Labs with Correct Credentials
    When the user inputs the correct username
    And the user inputs the correct password
    Then the user is redirected to the inventory page 
    
    Scenario: Logging into Swag Labs with Incorrect Credentials
      When the user inputs the correct username
      And the user inputs the incorrect password
      Then the user is still on the home page of Swag Labs
      
