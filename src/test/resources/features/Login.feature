Feature: Login functionality

  Scenario Outline: Invalid login attempts
    Given User is on login page
    When User enters "<username>" and "<password>" and clicks login
    Then Error message should be "<errorMessage>"

    Examples:
      | username   | password     | errorMessage                                                         |
      |            | anyPassword | Epic sadface: Username is required                                   |
      | someUser   |             | Epic sadface: Password is required                                   |
      | wrongUser  | wrongPass   | Epic sadface: Username and password do not match any user in this service |

  Scenario: Successful login with valid credentials
    Given User is on login page
    When User enters "standard_user" and "secret_sauce" and clicks login
    Then User should be logged in and see "Swag Labs"
