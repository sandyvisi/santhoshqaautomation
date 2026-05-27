Feature: Check the registration form

  Scenario Outline: Fill the form using excel sheet
    Given user launches the url
    When user gets data using "<testcaseid>"
    Then user clicks submit button

    Examples:
      | testcaseid |
      | TC_01      |
      | TC_02      |
