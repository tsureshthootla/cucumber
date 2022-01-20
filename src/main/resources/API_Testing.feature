Feature: Validate Rest API's
Scenario: Retrieve the room details
    Given the rooms endpoint exists
    When I send a valid retrieve room details payload
    Then Status_code equals 200


    Scenario: Login with the credentials
        Given I set post posts API endpoint
        When I set HEADER param request content type as "application/json."
        And set request body
        And send POST HTTP request
        Then I receive valid HTTP response code 200