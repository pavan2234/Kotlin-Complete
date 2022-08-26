Feature: Testing Trainee data
  Scenario: Fetch Karate Api
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    And match $ contains id == 1