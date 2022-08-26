Feature:
  Scenario: Checking the data using fuzzy matcher
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    And match response.[0].h.values.id == '#ignore'
    And match response.[0].h.values.id == '#number'
    And match response.[0].h.values.name == '#string'
    And match response.[0].h.values.age == '#present'
    And match response.[0].h.values.area == '#notnull'
    And match response =='#array'
    And match response.[0].h.values.id == '#? _ == 1'
    #It is detecting only id value 1 so it is passing but for other values it is failling due to index 0
    #So change the index to match the desired value
    And match response.[1].h.values.id == '#? _ >= 2'
    And match response.[2].h.values.name == '#? _ == "Rahul" '
    #Indexing is also important in matching the objects, In database each row count as a index
    And match response.[0].h.values.name == '#string? _.length>=1'
    #To check the length of the string and the it is string or not
    And match response == '#[6]'
    #Because h is an array of length 6, list of 6 rows
    And match response == '#[6] #string412'
