Feature: To use the JSON path expression
Background: Setup the Base path
Given url 'http://localhost:9898"

Scenario: To get the value of property using json path expression 7 Given path /normal/webapi/all'
When method get
Then status 200

# Karate.jsonPath(doc, jsonPathExpression)

* def jobTitle = Karate.jsonPath(response, "$[?(@.jobid 1)].jobTitle")

* def jobDescription = Karate.jsonPath(response, "$[?(@.jobId == 1)].jobDescription")

* def experience = Karate.jsonPath(response, "$[?(@jobId == 1)].experience")

And print "Job Title ==> jobTitle
And print "Job Description ==> ", ", jobDescription
 And print "Experience , experience

