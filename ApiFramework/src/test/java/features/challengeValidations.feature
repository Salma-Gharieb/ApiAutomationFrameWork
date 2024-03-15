Feature: Validating challenge APIS
  Scenario: verify if user can fet all challenges successfully using GetChallengesApi
    Given Get challenges payload
    When user calls "GetChallengesApi" with "post" http request
    Then the Api call got success with status code 200
    And "status" in response body is "ok"

  Scenario: verify if user can join challenge successfully using AttendChallengeApi
    Given Attend challenge payload
    When user calls "AttendChallengeApi" with "post" http request
    Then the Api call got success with status code 200
    And "status" in response body is "ok"

  Scenario: verify if user can leave challenge successfully using LeaveChallengeApi
    Given Leave challenge payload
    When user calls "LeaveChallengeApi" with "post" http request
    Then the Api call got success with status code 200
    And "status" in response body is "ok"
