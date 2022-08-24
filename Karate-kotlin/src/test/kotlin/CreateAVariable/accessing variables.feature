Feature: Creating a Variable in karate framework
  Background: Creating background variables and acessing throughout feature
    * def b_company = "Techouts"
    * def b_id = 1869
    #Can be accessed in any scenario

  Scenario: To Create a variable and access any where
    Given def var_int = 10
    And def var_string = "Pavan"
    Then print "Int Variable ==>",var_int
    And print "String variable ==>",var_string
    And def var_int2 = var_int + 5
    Then print "New Variable = ",var_int2
    Then print "Background values-----",b_company,b_id


  Scenario: Replacing Gherkin keyword with "*"
    * def var_int1 = 20
    And def var_string1 = "Prashanth"
    Then print "Int Variable ==>",var_int1
    And print "String variable ==>",var_string1
    Then print "Background values-----",b_company,b_id