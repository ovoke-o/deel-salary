@Regression
Feature: As a user, I want to View salary insights for specific job roles by country

  Scenario Outline: Display salary insights for a selected role and country
    Given user is on the Deel Salary Insight page
    When user selects role "<role>" and country "<country>"
    Then salary insights for "<role>" and country "<country>" should be displayed
    Examples:
      | role              | country |
      | Accountant        | Brazil  |
      | QA Engineer       | Canada  |
      | Software Engineer | Japan   |