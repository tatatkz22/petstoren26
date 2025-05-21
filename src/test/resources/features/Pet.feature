Feature: Pet API Scenarios

  Scenario: Add and get a pet
    Given I add a new pet
    When I fetch the pet by ID
    Then The pet details should be returned

  Scenario: Delete a pet
    Given I add a new pet
    When I delete the pet
    Then The pet should be deleted
