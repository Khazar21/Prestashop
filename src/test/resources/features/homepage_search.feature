Feature: Home page
  As a user when I enter search term and click enter,
  system should display search page

  Scenario: Home page search functionality

    Given user is in home page

    When user inputs search term and clicks enter

    Then System should display page title contains- "Search"


