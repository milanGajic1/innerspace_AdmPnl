@APITest
Feature: API Schema Validation
  As a QA engineer
  I want to ensure various API responses match their expected schemas
  So that I can guarantee data integrity and correctness

  Scenario: Validate Module Version Response Schema
    Given the "Module Version" API is queried
    When the response is received
    Then the response conforms to the expected "Module Version" schema

  Scenario: Validate Access Permission Response Schema
    Given the "Access Permission" API is queried
    When the response is received
    Then the response conforms to the expected "Access Permission" schema

  Scenario: Validate Applications Response Schema
    Given the "Applications" API is queried
    When the response is received
    Then the response conforms to the expected "Applications" schema

  Scenario: Validate Applications Versions Response Schema
    Given the "Applications Versions" API is queried
    When the response is received
    Then the response conforms to the expected "Applications Versions" schema

  Scenario: Validate Customers Response Schema
    Given the "Customers" API is queried
    When the response is received
    Then the response conforms to the expected "Customers" schema

  Scenario: Validate Module Response Schema
    Given the "Module" API is queried
    When the response is received
    Then the response conforms to the expected "Module" schema

  Scenario: Validate Role Response Schema
    Given the "Role" API is queried
    When the response is received
    Then the response conforms to the expected "Role" schema

  Scenario: Validate Sub-Modules Response Schema
    Given the "Sub-Modules" API is queried
    When the response is received
    Then the response conforms to the expected "Sub-Modules" schema

  Scenario: Validate Sub-Modules Labels Response Schema
    Given the "Sub-Modules Labels" API is queried
    When the response is received
    Then the response conforms to the expected "Sub-Modules Labels" schema

  Scenario: Validate User Response Schema
    Given the "User" API is queried
    When the response is received
    Then the response conforms to the expected "User" schema
