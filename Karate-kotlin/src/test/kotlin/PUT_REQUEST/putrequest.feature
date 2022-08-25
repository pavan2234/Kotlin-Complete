Feature: Put request validation
  Background: Giving the url
    Given url 'http://localhost:8090'
  Scenario: Put request inserting the data
    Given path '/updateDetails'
    And request     {"id": 2,"name": "Shashi","age": "21","area": "Mulugu"}
    And headers {Accept:'application/json',Content-Type: 'application/json'}
    When method put
    And status 200
    And print response