Feature: Json schema validation using external file
  Background: Giving the url
    Given url 'http://localhost:8090'

  Scenario: schema validation using external file
    Given path '/CustomerEntry'
    * def actualResponse = read("../post.json")
    And request actualResponse
    And headers {Accept:'application/json',Content-Type: 'application/json'}
    When method post
    And status 200
    And match response ==
    """
  {
        "id": "#number",
        "name": "#string",
        "age": "#string",
        "area": "#string"
      }
    """
    And print response
