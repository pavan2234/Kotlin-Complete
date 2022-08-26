Feature: Post request validation
  Background: Giving the url
    Given url 'http://localhost:8090'
    Scenario: Post request inserting the data
      Given path '/CustomerEntry'
      And request     {"id": 7,"name": "Shahsi","age": "21","area": "Warangal"}
      And headers {Accept:'application/json',Content-Type: 'application/json'}
      When method post
      And status 200
      And print response

  Scenario: Post request inserting the data using external file
    Given path '/CustomerEntry'
    * def actualResponse = read("../post.json")
    And request actualResponse
    And headers {Accept:'application/json',Content-Type: 'application/json'}
    When method post
    And status 200
    And print response

