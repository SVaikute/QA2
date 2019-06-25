Feature: Test youtube subscription functionality

  Scenario: Youtube Subscription Test from different places
    Given user is on Home page
    When he search for channels at search field
    And choose to subscribe to channel with index 0 at search results page
    And he search for funny video at search field
    And select to open video by index 0
    And choose to subscribe to channel on video page
    And he navigates to home page
    And select to open Gaming section from Main Menu
    And choose to subscribe to channel on channels page
    Then Verify Subscriptions are available on main menu page
    And Verify Subscriptions are available on subscriptions page
    And he removes all subscriptions from subscription page
    And closes browser