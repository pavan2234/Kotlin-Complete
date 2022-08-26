Feature:1
  Scenario: Fetch details 1
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    And match response.[0].h.values.id == 1
    And match response.[0].h.values.name == 'Pavan'
    And match response.[0].h.values.age == '22'
    And match response.[0].h.values.area == 'Uppal'

