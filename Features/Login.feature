Feature: Login with Credentials

  @sanity @regression
  Scenario: Successful Login with Valid Credentials
    Given the user navigates to login page
    When user enters email as "test246@gmail.com" and password as "test246"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page
  #@regression
  #Scenario Outline: Login Data Driven
    #Given the user navigates to login page
    #When user enters email as "<email>" and password as "<password>"
    #And the user clicks on the Login button
    #Then the user should be redirected to the MyAccount Page
#
    #Examples: 
      #| email             | password |
      #| tester@gmail.com  | test123  |
      #| test246@gmail.com | test246  |
