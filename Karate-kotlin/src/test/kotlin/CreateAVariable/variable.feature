Feature: Creating a Variable in karate framework
  Scenario: To Create a variable
    #Use variable for repeating value
    #storing the data from external file
    #In the matcher expression
    #passing the data from one file to another

    #FORMAT-----<Gherkin Keyword><def><Variable_name>=<Value>
    # * <def><variable>=<value>

  Given def var_int = 10
    And def var_string = "Pavan"
    Then print "Int Variable ==>",var_int
    And print "String variable ==>",var_string
    And def var_int2 = var_int + 5
    Then print "New Variable = ",var_int2

    #output--------
    #2022-08-22 11:19:01.303 [main] INFO  com.intuit.karate - [print] Int Variable ==> 10
    #2022-08-22 11:19:01.307 [main] INFO  com.intuit.karate - [print] String variable ==> Pavan
    #2022-08-22 11:31:18.810 [main] INFO  com.intuit.karate - [print] New Variable =  15

  Scenario: Replacing Gherkin keyword with "*"
    * def var_int1 = 20
    And def var_string1 = "Prashanth"
    Then print "Int Variable ==>",var_int1
    And print "String variable ==>",var_string1

    #2022-08-22 11:22:28.353 [main] INFO  com.intuit.karate - [print] Int Variable ==> 20
    #2022-08-22 11:22:28.354 [main] INFO  com.intuit.karate - [print] String variable ==> Prashanth
