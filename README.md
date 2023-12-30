# Project Title: CharliesAngelsAutoDesign
Under this repo, team charlies(Jyoti,Minal,Netrika & Shweta) would be developing testing automation framework during Hawathorn23A Demo.

#Motivation: Getting better prospects in the field of Automation Testing

#Purpose: To get the hands on experience on Framework Design with the Help of Page Object Model, Cucumber and Keyword Driven Design Strategy.

#Difficulties and Learning: Exceptions Like NosuchelementException, Element Can't Invoke, NullPointerException, Session Timed Out and learning is how to get rid of those problems using Wait or conditional checking.

#Features:
Feature: Features to verify all the myntra loginpage related functionalities

Scenario: Verify Login Field is Marked With Asterik sign
	Given User is on myntra homepage
	When User click on login button
	Then Login field should be marked with Asterik sign

 Feature: This feature verify cart functionality like updation, reduction, items remained in cart/not, about promo code and history of registered user

  Scenario: Verify the updation of quantity of items in the cart
    Given Enter kalini in search component
    When user clicks on Kurta with Trousers & Dupatta
    Then Switch to newly opened PIP
    Then Select Size S
    Then Click on Add To Bag

  @WIP
  Scenario: Verify user able to apply prize filter
    Given Enter kalini in search component
    Then Select Prize Filter and apply value
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
Feature: Test CRUD Methods on reqres Sample Employee REST API Testing

  Scenario: Create Employee record
    Given I Set POST employee service api endpoint
    When Send a POST HTTP request with {string} and {string}
    Then I receive valid Response
Feature: Features to verify all the myntra wishlistpage related functionalities

  Scenario: Verify User is not Able to View WishList Items WithOut Login
    Given User navigate to wishlist page from myntra homepage
    When User clicks on wishlist option
    Then User gets message to login to view wishlist

  Scenario: Verify User Can Navigate To LoginPage From WishListPage
    Given User navigate to wishlist page from myntra homepage
    When User clicks on wishlist option
    Then User get login option to navigate to login page

#Properties Set
#allure.properties
allure.results.directory= target/allure-results

##Config
browser_name =Chrome
url_name=https://www.myntra.com
user_name =admin
password=admin

###Source Folders
1) src/main/java
base package-->Config Class,Locator Class, TestBase Class included
error package-->for including error Class ex. InvalidBrowserError
exception package-->for including generalised exceptions 
keyword package-->for including generalised functions throughout the project
Pages package-->for including all the Functional Pages ex-->HomePage, SearchResultPage,AddToBagPage, CheckOutPage,LoginPage, MenMenuPage, WishListPage
stepdefinitions package-->Hooks, Login, ProductCartFunction, ProductSearchResultPage, WishListPageSteps, RestApiOperations
Waits Package-->included wait functionalities

2) src/main/resources
   Config.properties File
   Log4j.properties File
   
3) src/test/java
   tests package-->TestRunner Class to include the Cucumber Plugin and Tests Class for testng test cases

3) src/test/resources



