Feature: 2
Scenario: Fetch details 2
Given url 'http://localhost:8090/getTraineeDetails'
When method GET
Then status 200
And match /root/element/h/values/id == 1
