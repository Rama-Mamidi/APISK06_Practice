@test1
Feature: Get details of a specific user

  Scenario Outline: Get detailed information for an user
    Given user opens the base URI
    And user passes the payload with all required details
    When user hits the "<endpoint>"
    Then user will check the data is obtained with "<status_code>"

    Examples: 
      | endpoint   | status_code |
      | api/users |         201 |
