Feature: Features to verify all the myntra product search result page related functionalities

  Scenario: Verify user is able to sort product by highToLow option
    Given User enters mango brand in search component
    When User clicks on glass magnifier
    Then On product search result page user should sort product by high to low price.

<<<<<<< HEAD
  Scenario: Verify user is able to sort product by low to high option
    Given User enters mango brand in search component
    When User clicks on glass magnifier
    Then On product search result page user should sort product by low to high price
=======
Scenario: Verify user is able to sort product by highToLow option
	Given User enters mango brand in search component
	When User clicks on glass magnifier
	Then On product search result page user should sort product by high to low price.

	
Scenario: Verify user is able to sort product by low to high option
	Given User enters mango brand in search component
	When User clicks on glass magnifier
	Then On product search result page user should sort product by low to high price
	
	
Scenario: Verify Dresses Filter on product search result page
	Given User enters mango brand in search component and hits enter
	When User select dresses filter from left side menu
	Then All the Mango dresses should get filter out 
>>>>>>> 1912854d6da3004b8220e1d1b1a8fee9fb0e2eab
