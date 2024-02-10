
Feature: Google Search
  @SmokeScenario
  Scenario: Find some cheese
    Given I am on Google search page
    When I search for "cheese"
    Then the page tile should start with "cheese"

  @reg
  Scenario Outline: Find some "<item>"
    Given I am on Google search page
    When I search for "<item>"
    Then the page tile should start with "<item>"

    Examples:
      | item   |
      | ghee |
      | Butter |



