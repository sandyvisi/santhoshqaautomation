Feature: Check the registration form

  Scenario Outline: Fill the form using excel sheet
    Given user launches the url
    When user gets data using "<TC_ID>"
    Then user clicks submit button

    Examples:
      | TC_ID |
      | TC_01 |
      | TC_02 |
