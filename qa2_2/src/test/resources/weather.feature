Feature: Test city coordinates

  Scenario: Coordinates check
    Given country: uk
    And city: London
    When we are requesting weather data
    Then longitude is -0.13
    And latitude is 51.51