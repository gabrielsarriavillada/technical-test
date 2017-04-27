Feature: Bet placement
@test
  Scenario Outline: Bet placement in football page
    Given user goes to homepage
    And user logs in
    And user navigates to a <sport> event
    When user adds first active selection to betslip
    And user places a '0.03' bet
    Then user balance is updated

    Examples:
    | sport    |
    | football |
    | tennis   |