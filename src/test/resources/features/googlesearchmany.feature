@Smoke
Feature: Google Search1
  Scenario Outline: Find some "<item>"
    Given I am on Google search page
    When I search for "<item>"
    Then the page tile should start with "<item>"

    Examples:
      | item   |
      | car |
      | bike |

