Feature: Features to verify all the myntra wishlistpage related functionalities

  Scenario: Verify User is not Able to View WishList Items WithOut Login
    Given User navigate to wishlist page from myntra homepage
    When User clicks on wishlist option
    Then User gets message to login to view wishlist

  Scenario: Verify User Can Navigate To LoginPage From WishListPage
    Given User navigate to wishlist page from myntra homepage
    When User clicks on wishlist option
    Then User get login option to navigate to login page
