Feature: Login functionality on SauceDemo login page

  Background:
    Given User is on login page

  @negative @requiredFields
  Scenario Outline: Invalid login attempts with missing required fields
    When User enters "<username>" and "<password>" and clicks login
    Then Error message should be "<errorMessage>"

    Examples:
      | username   | password     | errorMessage                       |
      |            | anyPassword | Epic sadface: Username is required |
      | someUser   |             | Epic sadface: Password is required |

  @negative @invalidCredentials
  Scenario Outline: Invalid login attempts with wrong credentials
    When User enters "<username>" and "<password>" and clicks login
    Then Error message should be "Epic sadface: Username and password do not match any user in this service"

    Examples:
      | username      | password       |
      | wrong_user    | secret_sauce   |
      | standard_user | wrong_password |
      | wrong_user    | wrong_password |

  @positive @smoke
  Scenario: Successful login with valid credentials
    When User enters "standard_user" and "secret_sauce" and clicks login
    Then User should be logged in and see "Swag Labs"

  @negative @blocked
  Scenario: Login with locked out user
    When User enters "locked_out_user" and "secret_sauce" and clicks login
    Then Error message should be "Epic sadface: Sorry, this user has been locked out."

  @positive
  Scenario: Login with problem user
    When User enters "problem_user" and "secret_sauce" and clicks login
    Then User should be logged in and see "Swag Labs"

  @edge @negative
  Scenario: Login with username and password containing spaces
    When User enters " standard_user " and " secret_sauce " and clicks login
    Then Error message should be "Epic sadface: Username and password do not match any user in this service"

  @security @negative
  Scenario: Login with SQL injection attempt
    When User enters "' OR 1=1 --" and "anything" and clicks login
    Then Error message should be "Epic sadface: Username and password do not match any user in this service"

  @edge @negative
  Scenario: Login with extremely long password
    When User enters "standard_user" and "averyveryveryverylongpasswordthatexceedsnormalinput" and clicks login
    Then Error message should be "Epic sadface: Username and password do not match any user in this service"
