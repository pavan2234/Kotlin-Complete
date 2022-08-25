Feature: Matching Feature
  Scenario: Matching Hello World
    Given url 'http://localhost:8090/helloworld'
    When method GET
    Then status 200
    And match $ == 'Hello World'

  Scenario: Contains the data or not
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    And match $ contains {"h":{"entityClass":{},"values":{"id":1,"name":"Pavan","age":"22","area":"Uppal"}}}

  Scenario: Contains the data or not in json format
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    And match response contains
    """
    [
    {
        "h": {
            "entityClass": {},
            "values": {
                "id": 6,
                "name": "Shahsi",
                "age": "21",
                "area": "Warangal"
            }
        }
    }
    ]
    """

  Scenario: Deep method to find the object
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    #And match $ contains id == 1
    #Fails because it cannot find the path for id, So we have to use the deep method
    And match response contains deep [{"h": {"entityClass": {},"values": {"id": 1}}}]

  Scenario: Without deep method by directly giving the json path JSON VALIDATION
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    And match response.[0].h.values.id == 1
    And match response.[0].h.values.name == 'Pavan'
    And match response.[0].h.values.age == '22'
    And match response.[0].h.values.area == 'Uppal'

  Scenario: Without deep method by directly giving the json path JSON VALIDATION {INDEX MANIPULATION}
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    And match response.[1].h.values.id == 2
    And match response.[1].h.values.name == 'Pavan'
    And match response.[1].h.values.age == '22'
    And match response.[1].h.values.area == 'Uppal'

  Scenario: JSON ARRAY size validating
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    And match response == '#[6]'
    #[] indicates for json array so it will check for array length but internally their is no array only strings
    #So the no of rows here assumed as json array length



  Scenario: Using wild card character
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    And match response[*] contains
    #[*] represents the complete length of the array
    """
    [{"h": {"entityClass": {},"values": {"id": 6,"name": "Shahsi","age": "21","area": "Warangal"}}}]
    """
    And match response[*] == [{"h":{"entityClass":{},"values":{"id":1,"name":"Pavan","age":"22","area":"Uppal"}}},{"h":{"entityClass":{},"values":{"id":2,"name":"Pavan","age":"22","area":"Uppal"}}},{"h":{"entityClass":{},"values":{"id":3,"name":"Rahul","age":"21","area":"Sec"}}},{"h":{"entityClass":{},"values":{"id":4,"name":"Madan","age":"21","area":"Nara"}}},{"h":{"entityClass":{},"values":{"id":5,"name":"Umesh","age":"21","area":"Boduppal"}}},{"h":{"entityClass":{},"values":{"id":6,"name":"Shahsi","age":"21","area":"Warangal"}}}][{"h":{"entityClass":{},"values":{"id":6,"name":"Shahsi","age":"21","area":"Warangal"}}}]

  Scenario: XML VALIDATION by giving the xml path
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    #And match /root/element/h/values/id contains 1 #also can written
    And match response/root/element/h/values/id contains 1
    #In the program the format is not able to change itself so it is failing

  Scenario: XML VALIDATION by giving the xml path by Travesing
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
      # And match header Content-Type =  'application/json'
    And match response.root.element.h.values.id contains 1
    #This is the TRAVERSE of xml similar to json but due to conversion problem it will also be failed



