Feature: Calling one file from another
  Background: 
    Given url 'http://localhost:8090'
  Scenario: Calling putrequest file while getting the data
    Given path '/getTraineeDetails'
    Given call read ("../putrequest.feature")
    When method GET
    Then status 200
    And match $ contains {"h":{"entityClass":{},"values":{"id":1,"name":"Pavan","age":"22","area":"uppal-boduppal"}}}
    