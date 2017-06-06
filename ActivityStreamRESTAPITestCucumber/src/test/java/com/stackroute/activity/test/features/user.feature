Feature: Testing the CRUD operations of the User Spring Rest Controller

 Scenario: GET All Users - success
    When user sends a GET request with "http://localhost:8080/ActivityRestService/user/"
    Then status code should be 200
    And response type should be "json"
    And response should be following JSON:
    """
    [
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Abbas",
    "name": "Abbas",
    "password": "password2"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Anuradha",
    "name": "Anuradha",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Debjit",
    "name": "Debjit",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Dinesh",
    "name": "Dinesh",
    "password": "Dinesh"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Dinesh2",
    "name": "Dinesh2",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Farooq",
    "name": "Farooq",
    "password": "Farooq"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Hushnoon",
    "name": "Hushnoon",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "JP",
    "name": "JP",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Koel",
    "name": "Koel",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Partha",
    "name": "partha",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "sam",
    "name": "sam jones",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Shaubhik",
    "name": "Shaubhik",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "ShaubhikSen",
    "name": "shaubhiksen",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Som",
    "name": "Som",
    "password": "Som"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Somsubhra",
    "name": "somsubhra",
    "password": "password"
  },
  {
    "errorCode": null,
    "errorMessage": null,
    "id": "Soumya",
    "name": "Soumya",
    "password": "password"
  }
]
    """
    
    
    
 Scenario: GET All Users - empty
    When user sends a GET request with "http://localhost:8080/ActivityRestService/user/"
    Then status code should be 200
    And response type should be "json"
    And response should be empty   
    
    
    
 Scenario: GET All Users - mismatch
    When user sends a GET request with "http://localhost:8080/ActivityRestService/user/"
    Then status code should be 200
    And response type should be "json"
    And response is not matching following JSON:
    """
    [
  		{
    		"errorCode": null,
    		"errorMessage": null,
    		"id": "Abbas",
    		"name": "Abbas",
    		"password": "password2"
  		},
		  {
		    "errorCode": null,
		    "errorMessage": null,
		    "id": "Anuradha",
		    "name": "Anuradha",
		    "password": "password"
		  }
]
    """  
    
    
 Scenario: GET a specific user - success
    When user sends a GET request with "http://localhost:8080/ActivityRestService/user/id/Abbas"
    Then status code should be 200
    And response type should be "json"
    And response should be following user JSON:
    """
  {
  "errorCode": null,
  "errorMessage": null,
  "id": "Abbas",
  "name": "Abbas",
  "password": "password2"
}
    """
  
Scenario: GET a specific user - not found
    When user sends a GET request with "http://localhost:8080/ActivityRestService/user/id/Abbas2"
    Then status code should be 200
    And errorCode should be "404"
    And errorMessage should be "User not found"
    And response type should be "json"
    
    
    
Scenario: GET a specific user - mismatch
    When user sends a GET request with "http://localhost:8080/ActivityRestService/user/id/Abbas"
    Then status code should be 200
    And errorCode should be "404"
    And errorMessage should be "User not found"
    And response type should be "json"
    And response is not matching following JSON:
    """
  {
  "errorCode": null,
  "errorMessage": null,
  "id": "Abbas",
  "name": "Abbas",
  "password": "password"
}
    """         
 
 
Scenario: Create a new user - success
    When user sends a POST request with "http://localhost:8080/ActivityRestService/user/" with following JSON:
    """
    {
		  
		  "id": "john",
		  "name": "John Doe",
		  "password": "password"
	}
    """
    Then status code should be 200         
    And errorCode should be "200"
    And errorMessage should be "User created successfully"
    
Scenario: Create a new user with existing username
    When user sends a POST request with "http://localhost:8080/ActivityRestService/user/" with following JSON:
    """
    {
    	  "id": "john",
		  "name": "John Doe",
		  "password": "password"
    }
    """
    Then status code should be 200
    And errorCode should be "409"
    And errorMessage should be "User with the name John Doe already exists"  
    
    

Scenario: Updating an existing user - success
    When user sends a PUT request with "http://localhost:8080/ActivityRestService/user/john" with following JSON:
    """
    {
    	 "id": "john",
		  "name": "John Doe",
		  "password": "password@123"
    }
    """
    Then status code should be 200
    And errorCode should be "200"
    And errorMessage should be "User updated"
    And response type should be "json"
    And response is matching following JSON:
    """
  	{
  		  "errorCode":"200",
  		  "errorMessage":"User updated",
    	  "id": "john",
		  "name": "John Doe",
		  "password": "password@123"
  	}
    """      
    
    
Scenario: Updating an user - user not found
    When user sends a PUT request with "http://localhost:8080/ActivityRestService/user/john2" with following JSON:
    """
    {
    	 "id": "john2",
		  "name": "John Doe",
		  "password": "password@123"
    }
    """
    Then status code should be 200
    And errorCode should be "404"
    And errorMessage should be "User with the name John Doe not found"
    And response type should be "json"
              
    
Scenario: Authenticating a user - success
    When user sends a POST request with "http://localhost:8080/ActivityRestService/user/authenticate" with following JSON:
    """
    {
    	  "id": "john",
		  "password": "password@123"
    }
    """
    Then status code should be 200
    And errorCode should be "200"
    And errorMessage should be "Authentication successful"


Scenario: Authenticating a user - incorrect User ID
    When user sends a POST request with "http://localhost:8080/ActivityRestService/user/authenticate" with following JSON:
    """
    {
    	  "id": "john2",
		  "password": "password@123"
    }
    """
    Then status code should be 200
    And errorCode should be "404"
    And errorMessage should be "Authentication failure" 
    
    
Scenario: Authenticating a user - incorrect Password
    When user sends a POST request with "http://localhost:8080/ActivityRestService/user/authenticate" with following JSON:
    """
    {
    	  "id": "john",
		  "password": "password@1234"
    }
    """
    Then status code should be 200
    And errorCode should be "404"
    And errorMessage should be "Authentication failure"       

                
                
Scenario: Authenticating a user - incorrect User ID and password
    When user sends a POST request with "http://localhost:8080/ActivityRestService/user/authenticate" with following JSON:
    """
    {
    	  "id": "john2",
		  "password": "password@1234"
    }
    """
    Then status code should be 200
    And errorCode should be "404"
    And errorMessage should be "Authentication failure"                   