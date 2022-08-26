Feature: Reading data from external file of any format
   Background: Data accessing in external file
     Given url 'http://localhost:8090'
     Scenario: Reading data
       Given path '/getTraineeDetails'
       When method get
       Then status 200
       * def actualResponse = read("../Jasonformat.json")
       And print "File == ",actualResponse
       And match response contains actualResponse