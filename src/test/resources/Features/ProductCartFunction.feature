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
