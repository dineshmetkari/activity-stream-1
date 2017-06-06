$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("circle.feature");
formatter.feature({
  "line": 1,
  "name": "Testing the CRUD operations of the Circle Spring Rest Controller",
  "description": "",
  "id": "testing-the-crud-operations-of-the-circle-spring-rest-controller",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Create a new circle - success",
  "description": "",
  "id": "testing-the-crud-operations-of-the-circle-spring-rest-controller;create-a-new-circle---success",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user sends a POST request to create circle with \"http://localhost:8080/ActivityRestService/circle/create\" with following JSON:",
  "keyword": "When ",
  "doc_string": {
    "content_type": "",
    "line": 5,
    "value": "{\r\n  \"id\": \"SampleCircle\",\r\n  \"name\": \"SampleCircle\",\r\n  \"adminID\": \"john\",\r\n  \r\n}"
  }
});
formatter.step({
  "line": 13,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "errorCode should be \"200\"",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "errorMessage should be \"Circle created successfully\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "response should contain circle id \"SampleCircle\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "response should contain circle name \"SampleCircle\"",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "response should contain circle adminID \"john\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/circle/create",
      "offset": 49
    }
  ],
  "location": "CircleStepDefinition.user_sends_a_POST_request_to_create_circle_with_with_following_JSON(String,String)"
});
formatter.result({
  "duration": 964033839,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 2524170,
  "error_message": "java.lang.NullPointerException\r\n\tat com.stackroute.activity.test.stepdefinitions.UserStepDefinition.status_code_should_be(UserStepDefinition.java:53)\r\n\tat ✽.Then status code should be 200(circle.feature:13)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Circle created successfully",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "SampleCircle",
      "offset": 35
    }
  ],
  "location": "CircleStepDefinition.response_should_contain_circle_id(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "SampleCircle",
      "offset": 37
    }
  ],
  "location": "CircleStepDefinition.response_should_contain_circle_name(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "john",
      "offset": 40
    }
  ],
  "location": "CircleStepDefinition.response_should_contain_circle_adminID(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("user.feature");
formatter.feature({
  "line": 1,
  "name": "Testing the CRUD operations of the User Spring Rest Controller",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "GET All Users - success",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;get-all-users---success",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user sends a GET request with \"http://localhost:8080/ActivityRestService/user/\"",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "response type should be \"json\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "response should be following JSON:",
  "keyword": "And ",
  "doc_string": {
    "content_type": "",
    "line": 8,
    "value": "[\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Abbas\",\r\n\"name\": \"Abbas\",\r\n\"password\": \"password2\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Anuradha\",\r\n\"name\": \"Anuradha\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Debjit\",\r\n\"name\": \"Debjit\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Dinesh\",\r\n\"name\": \"Dinesh\",\r\n\"password\": \"Dinesh\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Dinesh2\",\r\n\"name\": \"Dinesh2\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Farooq\",\r\n\"name\": \"Farooq\",\r\n\"password\": \"Farooq\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Hushnoon\",\r\n\"name\": \"Hushnoon\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"JP\",\r\n\"name\": \"JP\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Koel\",\r\n\"name\": \"Koel\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Partha\",\r\n\"name\": \"partha\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"sam\",\r\n\"name\": \"sam jones\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Shaubhik\",\r\n\"name\": \"Shaubhik\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"ShaubhikSen\",\r\n\"name\": \"shaubhiksen\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Som\",\r\n\"name\": \"Som\",\r\n\"password\": \"Som\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Somsubhra\",\r\n\"name\": \"somsubhra\",\r\n\"password\": \"password\"\r\n},\r\n{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Soumya\",\r\n\"name\": \"Soumya\",\r\n\"password\": \"password\"\r\n}\r\n]"
  }
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/",
      "offset": 31
    }
  ],
  "location": "UserStepDefinition.user_sends_a_GET_request_with(String)"
});
formatter.result({
  "duration": 38707687,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 2724943,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "json",
      "offset": 25
    }
  ],
  "location": "UserStepDefinition.response_type_should_be(String)"
});
formatter.result({
  "duration": 319815,
  "status": "passed"
});
formatter.match({
  "location": "UserStepDefinition.response_should_be_following_JSON(String)"
});
formatter.result({
  "duration": 52768887,
  "error_message": "java.lang.AssertionError: expected:\u003c[{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Abbas\",\"name\":\"Abbas\",\"password\":\"password2\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Anuradha\",\"name\":\"Anuradha\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Debjit\",\"name\":\"Debjit\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Dinesh\",\"name\":\"Dinesh\",\"password\":\"Dinesh\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Dinesh2\",\"name\":\"Dinesh2\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Farooq\",\"name\":\"Farooq\",\"password\":\"Farooq\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Hushnoon\",\"name\":\"Hushnoon\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"JP\",\"name\":\"JP\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Koel\",\"name\":\"Koel\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Partha\",\"name\":\"partha\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"sam\",\"name\":\"sam jones\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Shaubhik\",\"name\":\"Shaubhik\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"ShaubhikSen\",\"name\":\"shaubhiksen\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Som\",\"name\":\"Som\",\"password\":\"Som\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Somsubhra\",\"name\":\"somsubhra\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Soumya\",\"name\":\"Soumya\",\"password\":\"password\"}]\u003e but was:\u003c[{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Abbas\",\"name\":\"Abbas\",\"password\":\"password2\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Anuradha\",\"name\":\"Anuradha\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Debjit\",\"name\":\"Debjit\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Dinesh\",\"name\":\"Dinesh\",\"password\":\"Dinesh\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Dinesh2\",\"name\":\"Dinesh2\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Farooq\",\"name\":\"Farooq\",\"password\":\"Farooq\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Hushnoon\",\"name\":\"Hushnoon\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"john\",\"name\":\"John Doe\",\"password\":\"password@123\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"JP\",\"name\":\"JP\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Koel\",\"name\":\"Koel\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Partha\",\"name\":\"partha\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"sam\",\"name\":\"sam jones\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Shaubhik\",\"name\":\"Shaubhik\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"ShaubhikSen\",\"name\":\"shaubhiksen\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"simanta\",\"name\":\"simanta\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Som\",\"name\":\"Som\",\"password\":\"Som\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Somsubhra\",\"name\":\"somsubhra\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Soumya\",\"name\":\"Soumya\",\"password\":\"password\"}]\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:743)\r\n\tat org.junit.Assert.assertEquals(Assert.java:118)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.stackroute.activity.test.stepdefinitions.UserStepDefinition.response_should_be_following_JSON(UserStepDefinition.java:70)\r\n\tat ✽.And response should be following JSON:(user.feature:7)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 127,
  "name": "GET All Users - empty",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;get-all-users---empty",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 128,
  "name": "user sends a GET request with \"http://localhost:8080/ActivityRestService/user/\"",
  "keyword": "When "
});
formatter.step({
  "line": 129,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 130,
  "name": "response type should be \"json\"",
  "keyword": "And "
});
formatter.step({
  "line": 131,
  "name": "response should be empty",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/",
      "offset": 31
    }
  ],
  "location": "UserStepDefinition.user_sends_a_GET_request_with(String)"
});
formatter.result({
  "duration": 24500793,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 174122,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "json",
      "offset": 25
    }
  ],
  "location": "UserStepDefinition.response_type_should_be(String)"
});
formatter.result({
  "duration": 177675,
  "status": "passed"
});
formatter.match({
  "location": "UserStepDefinition.response_should_be_empty()"
});
formatter.result({
  "duration": 2977834,
  "error_message": "java.lang.AssertionError: expected:\u003c[]\u003e but was:\u003c[{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Abbas\",\"name\":\"Abbas\",\"password\":\"password2\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Anuradha\",\"name\":\"Anuradha\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Debjit\",\"name\":\"Debjit\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Dinesh\",\"name\":\"Dinesh\",\"password\":\"Dinesh\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Dinesh2\",\"name\":\"Dinesh2\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Farooq\",\"name\":\"Farooq\",\"password\":\"Farooq\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Hushnoon\",\"name\":\"Hushnoon\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"john\",\"name\":\"John Doe\",\"password\":\"password@123\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"JP\",\"name\":\"JP\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Koel\",\"name\":\"Koel\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Partha\",\"name\":\"partha\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"sam\",\"name\":\"sam jones\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Shaubhik\",\"name\":\"Shaubhik\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"ShaubhikSen\",\"name\":\"shaubhiksen\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"simanta\",\"name\":\"simanta\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Som\",\"name\":\"Som\",\"password\":\"Som\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Somsubhra\",\"name\":\"somsubhra\",\"password\":\"password\"},{\"errorCode\":null,\"errorMessage\":null,\"id\":\"Soumya\",\"name\":\"Soumya\",\"password\":\"password\"}]\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:743)\r\n\tat org.junit.Assert.assertEquals(Assert.java:118)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.stackroute.activity.test.stepdefinitions.UserStepDefinition.response_should_be_empty(UserStepDefinition.java:81)\r\n\tat ✽.And response should be empty(user.feature:131)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 135,
  "name": "GET All Users - mismatch",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;get-all-users---mismatch",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 136,
  "name": "user sends a GET request with \"http://localhost:8080/ActivityRestService/user/\"",
  "keyword": "When "
});
formatter.step({
  "line": 137,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 138,
  "name": "response type should be \"json\"",
  "keyword": "And "
});
formatter.step({
  "line": 139,
  "name": "response is not matching following JSON:",
  "keyword": "And ",
  "doc_string": {
    "content_type": "",
    "line": 140,
    "value": "[\r\n{\r\n\t\t\"errorCode\": null,\r\n\t\t\"errorMessage\": null,\r\n\t\t\"id\": \"Abbas\",\r\n\t\t\"name\": \"Abbas\",\r\n\t\t\"password\": \"password2\"\r\n},\r\n{\r\n  \"errorCode\": null,\r\n  \"errorMessage\": null,\r\n  \"id\": \"Anuradha\",\r\n  \"name\": \"Anuradha\",\r\n  \"password\": \"password\"\r\n}\r\n]"
  }
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/",
      "offset": 31
    }
  ],
  "location": "UserStepDefinition.user_sends_a_GET_request_with(String)"
});
formatter.result({
  "duration": 29486946,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 167607,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "json",
      "offset": 25
    }
  ],
  "location": "UserStepDefinition.response_type_should_be(String)"
});
formatter.result({
  "duration": 194258,
  "status": "passed"
});
formatter.match({
  "location": "UserStepDefinition.response_is_not_matching_following_JSON(String)"
});
formatter.result({
  "duration": 1570647,
  "status": "passed"
});
formatter.scenario({
  "line": 160,
  "name": "GET a specific user - success",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;get-a-specific-user---success",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 161,
  "name": "user sends a GET request with \"http://localhost:8080/ActivityRestService/user/id/Abbas\"",
  "keyword": "When "
});
formatter.step({
  "line": 162,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 163,
  "name": "response type should be \"json\"",
  "keyword": "And "
});
formatter.step({
  "line": 164,
  "name": "response should be following user JSON:",
  "keyword": "And ",
  "doc_string": {
    "content_type": "",
    "line": 165,
    "value": "{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Abbas\",\r\n\"name\": \"Abbas\",\r\n\"password\": \"password2\"\r\n}"
  }
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/id/Abbas",
      "offset": 31
    }
  ],
  "location": "UserStepDefinition.user_sends_a_GET_request_with(String)"
});
formatter.result({
  "duration": 22483589,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 113120,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "json",
      "offset": 25
    }
  ],
  "location": "UserStepDefinition.response_type_should_be(String)"
});
formatter.result({
  "duration": 102459,
  "status": "passed"
});
formatter.match({
  "location": "UserStepDefinition.response_should_be_following_user_JSON(String)"
});
formatter.result({
  "duration": 158723,
  "status": "passed"
});
formatter.scenario({
  "line": 175,
  "name": "GET a specific user - not found",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;get-a-specific-user---not-found",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 176,
  "name": "user sends a GET request with \"http://localhost:8080/ActivityRestService/user/id/Abbas2\"",
  "keyword": "When "
});
formatter.step({
  "line": 177,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 178,
  "name": "errorCode should be \"404\"",
  "keyword": "And "
});
formatter.step({
  "line": 179,
  "name": "errorMessage should be \"User not found\"",
  "keyword": "And "
});
formatter.step({
  "line": 180,
  "name": "response type should be \"json\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/id/Abbas2",
      "offset": 31
    }
  ],
  "location": "UserStepDefinition.user_sends_a_GET_request_with(String)"
});
formatter.result({
  "duration": 24161433,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 161684,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "duration": 329291,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "User not found",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "duration": 240454,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "json",
      "offset": 25
    }
  ],
  "location": "UserStepDefinition.response_type_should_be(String)"
});
formatter.result({
  "duration": 136810,
  "status": "passed"
});
formatter.scenario({
  "line": 184,
  "name": "GET a specific user - mismatch",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;get-a-specific-user---mismatch",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 185,
  "name": "user sends a GET request with \"http://localhost:8080/ActivityRestService/user/id/Abbas\"",
  "keyword": "When "
});
formatter.step({
  "line": 186,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 187,
  "name": "errorCode should be \"404\"",
  "keyword": "And "
});
formatter.step({
  "line": 188,
  "name": "errorMessage should be \"User not found\"",
  "keyword": "And "
});
formatter.step({
  "line": 189,
  "name": "response type should be \"json\"",
  "keyword": "And "
});
formatter.step({
  "line": 190,
  "name": "response is not matching following JSON:",
  "keyword": "And ",
  "doc_string": {
    "content_type": "",
    "line": 191,
    "value": "{\r\n\"errorCode\": null,\r\n\"errorMessage\": null,\r\n\"id\": \"Abbas\",\r\n\"name\": \"Abbas\",\r\n\"password\": \"password\"\r\n}"
  }
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/id/Abbas",
      "offset": 31
    }
  ],
  "location": "UserStepDefinition.user_sends_a_GET_request_with(String)"
});
formatter.result({
  "duration": 19926253,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 158131,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "duration": 1794517,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "User not found",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "duration": 1703904,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "json",
      "offset": 25
    }
  ],
  "location": "UserStepDefinition.response_type_should_be(String)"
});
formatter.result({
  "duration": 127926,
  "status": "passed"
});
formatter.match({
  "location": "UserStepDefinition.response_is_not_matching_following_JSON(String)"
});
formatter.result({
  "duration": 178267,
  "status": "passed"
});
formatter.scenario({
  "line": 202,
  "name": "Create a new user - success",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;create-a-new-user---success",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 203,
  "name": "user sends a POST request with \"http://localhost:8080/ActivityRestService/user/\" with following JSON:",
  "keyword": "When ",
  "doc_string": {
    "content_type": "",
    "line": 204,
    "value": "{\r\n\r\n\"id\": \"john\",\r\n\"name\": \"John Doe\",\r\n\"password\": \"password\"\r\n}"
  }
});
formatter.step({
  "line": 212,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 213,
  "name": "errorCode should be \"200\"",
  "keyword": "And "
});
formatter.step({
  "line": 214,
  "name": "errorMessage should be \"User created successfully\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/",
      "offset": 32
    }
  ],
  "location": "UserStepDefinition.user_sends_a_POST_request_with_with_following_JSON(String,String)"
});
formatter.result({
  "duration": 17694063,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 116673,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "duration": 499267,
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[200]\u003e but was:\u003c[409]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.stackroute.activity.test.stepdefinitions.UserStepDefinition.errorcode_should_be(UserStepDefinition.java:162)\r\n\tat ✽.And errorCode should be \"200\"(user.feature:213)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "User created successfully",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 216,
  "name": "Create a new user with existing username",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;create-a-new-user-with-existing-username",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 217,
  "name": "user sends a POST request with \"http://localhost:8080/ActivityRestService/user/\" with following JSON:",
  "keyword": "When ",
  "doc_string": {
    "content_type": "",
    "line": 218,
    "value": "{\r\n\t  \"id\": \"john\",\r\n\"name\": \"John Doe\",\r\n\"password\": \"password\"\r\n}"
  }
});
formatter.step({
  "line": 225,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 226,
  "name": "errorCode should be \"409\"",
  "keyword": "And "
});
formatter.step({
  "line": 227,
  "name": "errorMessage should be \"User with the name John Doe already exists\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/",
      "offset": 32
    }
  ],
  "location": "UserStepDefinition.user_sends_a_POST_request_with_with_following_JSON(String,String)"
});
formatter.result({
  "duration": 17364180,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 169976,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "409",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "duration": 168199,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "User with the name John Doe already exists",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "duration": 106605,
  "status": "passed"
});
formatter.scenario({
  "line": 231,
  "name": "Updating an existing user - success",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;updating-an-existing-user---success",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 232,
  "name": "user sends a PUT request with \"http://localhost:8080/ActivityRestService/user/john\" with following JSON:",
  "keyword": "When ",
  "doc_string": {
    "content_type": "",
    "line": 233,
    "value": "{\r\n\t \"id\": \"john\",\r\n\"name\": \"John Doe\",\r\n\"password\": \"password@123\"\r\n}"
  }
});
formatter.step({
  "line": 240,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 241,
  "name": "errorCode should be \"200\"",
  "keyword": "And "
});
formatter.step({
  "line": 242,
  "name": "errorMessage should be \"User updated\"",
  "keyword": "And "
});
formatter.step({
  "line": 243,
  "name": "response type should be \"json\"",
  "keyword": "And "
});
formatter.step({
  "line": 244,
  "name": "response is matching following JSON:",
  "keyword": "And ",
  "doc_string": {
    "content_type": "",
    "line": 245,
    "value": "{\r\n  \"errorCode\":\"200\",\r\n  \"errorMessage\":\"User updated\",\r\n\t  \"id\": \"john\",\r\n\"name\": \"John Doe\",\r\n\"password\": \"password@123\"\r\n}"
  }
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/john",
      "offset": 31
    }
  ],
  "location": "UserStepDefinition.user_sends_a_PUT_request_with_with_following_JSON(String,String)"
});
formatter.result({
  "duration": 123589557,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 148062,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "duration": 187151,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "User updated",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "duration": 236308,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "json",
      "offset": 25
    }
  ],
  "location": "UserStepDefinition.response_type_should_be(String)"
});
formatter.result({
  "duration": 178860,
  "status": "passed"
});
formatter.match({
  "location": "UserStepDefinition.response_is_matching_following_JSON(String)"
});
formatter.result({
  "duration": 928649,
  "status": "passed"
});
formatter.scenario({
  "line": 256,
  "name": "Updating an user - user not found",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;updating-an-user---user-not-found",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 257,
  "name": "user sends a PUT request with \"http://localhost:8080/ActivityRestService/user/john2\" with following JSON:",
  "keyword": "When ",
  "doc_string": {
    "content_type": "",
    "line": 258,
    "value": "{\r\n\t \"id\": \"john2\",\r\n\"name\": \"John Doe\",\r\n\"password\": \"password@123\"\r\n}"
  }
});
formatter.step({
  "line": 265,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 266,
  "name": "errorCode should be \"404\"",
  "keyword": "And "
});
formatter.step({
  "line": 267,
  "name": "errorMessage should be \"User with the name John Doe not found\"",
  "keyword": "And "
});
formatter.step({
  "line": 268,
  "name": "response type should be \"json\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/john2",
      "offset": 31
    }
  ],
  "location": "UserStepDefinition.user_sends_a_PUT_request_with_with_following_JSON(String,String)"
});
formatter.result({
  "duration": 30489625,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 161685,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "duration": 252298,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "User with the name John Doe not found",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "duration": 137402,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "json",
      "offset": 25
    }
  ],
  "location": "UserStepDefinition.response_type_should_be(String)"
});
formatter.result({
  "duration": 130295,
  "status": "passed"
});
formatter.scenario({
  "line": 271,
  "name": "Authenticating a user - success",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;authenticating-a-user---success",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 272,
  "name": "user sends a POST request with \"http://localhost:8080/ActivityRestService/user/authenticate\" with following JSON:",
  "keyword": "When ",
  "doc_string": {
    "content_type": "",
    "line": 273,
    "value": "{\r\n\t  \"id\": \"john\",\r\n\"password\": \"password@123\"\r\n}"
  }
});
formatter.step({
  "line": 279,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 280,
  "name": "errorCode should be \"200\"",
  "keyword": "And "
});
formatter.step({
  "line": 281,
  "name": "errorMessage should be \"Authentication successful\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/authenticate",
      "offset": 32
    }
  ],
  "location": "UserStepDefinition.user_sends_a_POST_request_with_with_following_JSON(String,String)"
});
formatter.result({
  "duration": 28844354,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 169976,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "duration": 146285,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Authentication successful",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "duration": 111343,
  "status": "passed"
});
formatter.scenario({
  "line": 284,
  "name": "Authenticating a user - incorrect User ID",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;authenticating-a-user---incorrect-user-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 285,
  "name": "user sends a POST request with \"http://localhost:8080/ActivityRestService/user/authenticate\" with following JSON:",
  "keyword": "When ",
  "doc_string": {
    "content_type": "",
    "line": 286,
    "value": "{\r\n\t  \"id\": \"john2\",\r\n\"password\": \"password@123\"\r\n}"
  }
});
formatter.step({
  "line": 292,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 293,
  "name": "errorCode should be \"404\"",
  "keyword": "And "
});
formatter.step({
  "line": 294,
  "name": "errorMessage should be \"Authentication failure\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/authenticate",
      "offset": 32
    }
  ],
  "location": "UserStepDefinition.user_sends_a_POST_request_with_with_following_JSON(String,String)"
});
formatter.result({
  "duration": 28208870,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 183598,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "duration": 204918,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Authentication failure",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "duration": 225055,
  "status": "passed"
});
formatter.scenario({
  "line": 297,
  "name": "Authenticating a user - incorrect Password",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;authenticating-a-user---incorrect-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 298,
  "name": "user sends a POST request with \"http://localhost:8080/ActivityRestService/user/authenticate\" with following JSON:",
  "keyword": "When ",
  "doc_string": {
    "content_type": "",
    "line": 299,
    "value": "{\r\n\t  \"id\": \"john\",\r\n\"password\": \"password@1234\"\r\n}"
  }
});
formatter.step({
  "line": 305,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 306,
  "name": "errorCode should be \"404\"",
  "keyword": "And "
});
formatter.step({
  "line": 307,
  "name": "errorMessage should be \"Authentication failure\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/authenticate",
      "offset": 32
    }
  ],
  "location": "UserStepDefinition.user_sends_a_POST_request_with_with_following_JSON(String,String)"
});
formatter.result({
  "duration": 27657486,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 165237,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "duration": 187151,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Authentication failure",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "duration": 121411,
  "status": "passed"
});
formatter.scenario({
  "line": 311,
  "name": "Authenticating a user - incorrect User ID and password",
  "description": "",
  "id": "testing-the-crud-operations-of-the-user-spring-rest-controller;authenticating-a-user---incorrect-user-id-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 312,
  "name": "user sends a POST request with \"http://localhost:8080/ActivityRestService/user/authenticate\" with following JSON:",
  "keyword": "When ",
  "doc_string": {
    "content_type": "",
    "line": 313,
    "value": "{\r\n\t  \"id\": \"john2\",\r\n\"password\": \"password@1234\"\r\n}"
  }
});
formatter.step({
  "line": 319,
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 320,
  "name": "errorCode should be \"404\"",
  "keyword": "And "
});
formatter.step({
  "line": 321,
  "name": "errorMessage should be \"Authentication failure\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080/ActivityRestService/user/authenticate",
      "offset": 32
    }
  ],
  "location": "UserStepDefinition.user_sends_a_POST_request_with_with_following_JSON(String,String)"
});
formatter.result({
  "duration": 18505445,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "UserStepDefinition.status_code_should_be(int)"
});
formatter.result({
  "duration": 158130,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 21
    }
  ],
  "location": "UserStepDefinition.errorcode_should_be(String)"
});
formatter.result({
  "duration": 184782,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Authentication failure",
      "offset": 24
    }
  ],
  "location": "UserStepDefinition.errormessage_should_be(String)"
});
formatter.result({
  "duration": 160500,
  "status": "passed"
});
});