Feature:
  Scenario: Fetch details
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    And match reponse contains deep [{"h": {"entityClass": {},"values": {"id": 1}}}]