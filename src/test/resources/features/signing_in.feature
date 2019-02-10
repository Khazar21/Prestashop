Feature: Signing in
  Background:
    Given User is in sign in page

  Scenario: sign in functionality with valid credentials
 #   Given User is in sign in page
    When User puts valid credentials
    Then System should display page title contains- "My account"

  Scenario: sign in functionality with invalid username
    and valid password
 #   Given User is in sign in page
    When User puts invalid username and valid password
    Then System should display error message

  Scenario: sign in functionality with valid username
  and invalid password
  #  Given User is in sign in page
    When User puts valid username and invalid password
    Then System should display error message
  @signIn
  Scenario: sign in functionality with both invalid credentials
  #  Given User is in sign in page
    When User puts invalid username and invalid password
    Then System should display error message