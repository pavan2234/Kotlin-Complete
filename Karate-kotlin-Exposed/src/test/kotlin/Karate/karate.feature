Feature:
  Scenario: Fetch google.com
    Given url 'http://localhost:8090/getTraineeDetails'
    When method GET
    Then status 200
    #And match $ contains {"h":{"entityClass":{},"values":{"id":1,"name":"Pavan","age":"22","area":"Uppal"}}},{"h":{"entityClass":{},"values":{"id":2,"name":"Pavan","age":"22","area":"Uppal"}}},{"h":{"entityClass":{},"values":{"id":3,"name":"Pavan","age":"22","area":"Uppal"}}},{"h":{"entityClass":{},"values":{"id":4,"name":"Pavan","age":"22","area":"Uppal"}}},{"h":{"entityClass":{},"values":{"id":5,"name":"Pavan","age":"22","area":"Uppal"}}}]
    And match response contains
    """
    [
    {
        "h": {
            "entityClass": {},
            "values": {
                "id": 1,
                "name": "Pavan",
                "age": "22",
                "area": "Uppal"
            }
        }
    },
    {
        "h": {
            "entityClass": {},
            "values": {
                "id": 2,
                "name": "Pavan",
                "age": "22",
                "area": "Uppal"
            }
        }
    },
    {
        "h": {
            "entityClass": {},
            "values": {
                "id": 3,
                "name": "Rahul",
                "age": "21",
                "area": "Sec"
            }
        }
    },
    {
        "h": {
            "entityClass": {},
            "values": {
                "id": 4,
                "name": "Madan",
                "age": "21",
                "area": "Nara"
            }
        }
    },
    {
        "h": {
            "entityClass": {},
            "values": {
                "id": 5,
                "name": "Umesh",
                "age": "21",
                "area": "Boduppal"
            }
        }
    },
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