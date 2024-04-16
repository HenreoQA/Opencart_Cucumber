Feature: Registration of Account

  @regression
  Scenario: Successful Account Registration
    Given the user navigates to Register Account page
    When the user enters the details into below fields
      | firstName        | Mark              |
      | lastName         | Robert            |
      | Email            | test246@gmail.com |
      | telephone        |        1234567890 |
      | password         | test246           |
      | confirm password | test246           |
    And the user selects Privacy Policy
    And the user clicks on Continue button
    Then the user account should get created successfully
