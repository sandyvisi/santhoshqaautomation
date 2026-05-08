Feature: Login feature of the automation practice

  Scenario Outline: Login successful with valid credentials
    When User enters valid "<emailid>" and "<password>"

    Examples:
      | emailid       | password   |
      | sannn@med.com | Saibaba1@3 |
