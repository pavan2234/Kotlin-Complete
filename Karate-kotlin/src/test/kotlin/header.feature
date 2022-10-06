Feature: Matching Feature
  Scenario: Matching Hello World
    Given url 'https://api.qa.sandbox-riskcovry.com/api/partner/motor/get_rto_locations'
    When method GET
   # Then status 200
    Then match header 'Partner-Code' == 'SAMBHAVIT'
    Then match header 'Partner-Key' == 't4aH4gW3xtNPiQj3zE_d'
#    And match $ contains
#    """
#    {
#        "id": 365,
#        "code": "KA01",
#        "place_name": "Bengaluru",
#        "state_code": "11",
#        "state_name": "KARNATAKA",
#        "registration_code": "KA-1",
#        "pincode": "560007"
#    }
#    """