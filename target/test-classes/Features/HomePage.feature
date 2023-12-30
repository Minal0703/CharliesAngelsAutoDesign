Feature: Features to verify all the myntra homepage related functionalities


Scenario: Verify user can navigate to mens clothing from top menu
	Given User is on myntra homepage
	When User hovers on mens menu page
	And clicks on casual shirts
	Then User successfully navigates to mens clothing page


Scenario: Verify user can add product to bag
	Given User is on myntra homepage
	When User hovers on mens menu page
	And clicks on casual shirts to add one shirt into bag
	Then User is successful adding product into bag

	
Scenario: Verify user can remove product from bag
	Given User is on myntra homepage
	When User hovers on mens menu page
	And clicks on casual shirts to add one shirt into bag
	And User clicks on remove button 
	Then User is able to remove product from bag
	
	