@as.com
@issue=1234
@tmsLink=4321

Feature: Feature - Diario AS proof of concept for Prisa

  Background: Navigate to the home page
    Given The user is on the as.com home page
    And The user accepts cookies pop-up

  @Case01 @News
  @severity=blocker
  Scenario: Scenario - Access to a football team news
    When The user access Atletico de Madrid within the Futbol section
    Then The Atletico de Madrid team page is correct
    And The Atletico de Madrid news are displayed

  @Case02 @Home
  @severity=critical
  Scenario: Scenario - Return to home from a football page
    When The user access Atletico de Madrid within the Futbol section
    And The user clicks on the banner AS logo
    Then The user is redirected to the home page

  @Case03 @Facebook
  Scenario: Scenario - Share news with Facebook
    When The user clicks on the title of the first news
    Then The user is on the selected news page
    When The user clicks the Facebook icon
    Then The Facebook share window is displayed

  @Case04 @Advertisements
  Scenario: Scenario - Access to motor league news
    When The user access Formula One within the Motor section
    Then The Formula One league page is correct
    And The Formula One league advertisement elements are displayed
      | gtp_diarioas_19753-MPU1 |