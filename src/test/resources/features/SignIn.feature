Feature: Innerspace Administration Panel Sign-In

  Scenario: Successfully signing in with an existing Microsoft account
    Given I am on the Innerspace Admin Panel login page
    When I click on the sign-in button
    And I select an existing Microsoft user account
    Then I should be logged into the Admin Panel

  Scenario: User switches to dark mode after signing in
    Given I am logged into the Innerspace Admin Panel
    When I click on the dark mode button
    Then the application should switch to dark mode