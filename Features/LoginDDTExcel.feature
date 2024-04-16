Feature: Login Data Driven with Excel

  Scenario Outline: Login Data Driven Excel
    Given the user navigates to login page
    Then the user should be redirected to the MyAccount Page by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
  #Approach2
  #Scenario Outline: Login Data Driven Excel
    #Given the user navigates to login page
    #When the user enters the email and password with excel row "<row_index>"
    #Then the user should be redirected to MyAccount Page
#
    #Examples: 
      #| row_index |
      #|         1 |
      #|         2 |
      #|         3 |
      #|         4 |
      #|         5 |
