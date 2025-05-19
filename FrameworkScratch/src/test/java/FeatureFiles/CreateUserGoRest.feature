@test2
Feature: Create a new user in Gorest site

  Scenario Outline: Validate creation of new user in gorest
    Given user hits the gorest on its uri
    When user enters the authentication token
    And user passes the payload in gorest site with all the required details
    When user will hit the gorest "<endpoint>"
    Then user validates the status code as "<status_code>"
    Then user will validate the details in status body
      | endpoint        | status_code |
      | public/v2/users |         201 |
