@sanity
Feature: validate login functionality

  Background: 
    Given user opens the browser and enters the url and hits enter
    And user enters username in "<username>" field
    And user enters password in "<password>" field
    When user clicks on submit button

  @test1
  Scenario Outline: Validate login functionality with correct username and password
    Then user will be able to get to homepage of the application

    Examples: 
      | username | password  |
      | saurabh  | test@1234 |

  #|harry|test@4567|
  @test2
  Scenario Outline: Validate login functionality with incorrect username and password
    Then user will get invalid username as error message

    Examples: 
      | username | password  |
      | saurabh  | test@1234 |
#|harry|test@4567|
