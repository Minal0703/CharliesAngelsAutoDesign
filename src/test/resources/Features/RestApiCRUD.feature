Feature: Test CRUD Methods on reqres Sample Employee REST API Testing

  Scenario: Create Employee record
    Given I Set POST employee service api endpoint
    When Send a POST HTTP request with {string} and {string}
    Then I receive valid Response
