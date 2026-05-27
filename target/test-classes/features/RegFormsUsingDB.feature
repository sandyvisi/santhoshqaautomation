Feature: Check the registration form

  Scenario Outline: Fill the form using excel sheet
    Given user launches the url
    When user gets data using DB
    Then user clicks submit button
    
	
	Scenario: Fill the form using DB but without entering the number shown and click submit the form should not be submitted
	
	Given user launches the url
	When Except email field enter all other details
	But the form should not submitted   
	
	
	
	  
