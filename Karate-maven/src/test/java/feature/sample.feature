Feature: print hello world feature

  Scenario: Hello World scenario

    * print  'Hello world'
    * print  'This is karate'
    
    Scenario: Sum of numbers
      
      * def rent = 4500
      * def food = 3000
      * def fee = 10000
      * print 'Total is = '+(rent + food + fee)