Feature: Json complex schema validation
  Background: Giving the url
    Given url 'http://localhost:8090'

  Scenario:In the json format the internal schemas are validated with this validation
    Given path '/getTraineeDetails'
    And headers {Accept:'application/json',Content-Type: 'application/json'}
    When method get
    And status 200
    #* def mainschema = {"id": "#number","name": "#string","age": "#string","area": "#string"}
    #For method GET u have to use the as it is postman format of json as shown below BUT FOR POST YOU HAVE TO USE ABOVE FORMAT
    * def mainschema = [{"h":{"entityClass":{},"values":{"id":"#number","name":"#string","age":"#string","area":"#string"}}}]
    And match response ==
    """
    '##(mainschema)'
    """

