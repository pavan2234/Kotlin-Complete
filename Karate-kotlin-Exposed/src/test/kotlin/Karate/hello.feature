Feature:
  Scenario: Fetch google.com
    Given url 'http://localhost:8080/helloworld'
    When method GET
    Then status 200
  And match $ == 'Hello World'