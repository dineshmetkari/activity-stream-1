Feature: Testing the CRUD operations of the Circle Spring Rest Controller

Scenario: Create a new circle - success
    When user sends a POST request to create circle with "http://localhost:8080/ActivityRestService/circle/create" with following JSON:
    """
    {
		    "id": "SampleCircle",
		    "name": "SampleCircle",
		    "adminID": "john",
		    
	}
    """
    Then status code should be 200         
    And errorCode should be "200"
    And errorMessage should be "Circle created successfully"
    And response should contain circle id "SampleCircle"
    And response should contain circle name "SampleCircle"
    And response should contain circle adminID "john"
    