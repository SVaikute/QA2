Feature: Some Cucumber workshop

  Scenario: Student increase check
    Given student with attributes:
      | name | Robert       |
      | pk   | 111111-12345 |
      | age  | 88           |
    And student with attributes:
      | name | Valera       |
      | pk   | 222222-12453 |
      | age  | 50           |
    When we add a new student with attributes
      | name | Vazgen       |
      | pk   | 127867-12853 |
      | age  | 14           |
    Then student count is 3
    And last student age is 14