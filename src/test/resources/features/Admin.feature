@add-delete-user
Feature: Login as an admin and add/delete user.

  Background: Login as an admin.
    Given I should navigated to login page
    When  I enter "Admin" as username
    And   I enter "admin123" as password
    And   I click on login button
    Then  I should navigated to home page
    When  I click on Admin tab on the left side menu
    Then  I should navigated to admin page

  @add-user
  Scenario: Verify that number of records after adding one more record
    Given I should see number of records displayed
    When  I click on add button
    And   I enter the employee name as "Orange", username as "sayed157", password as "Qazwsx157#"
    And   I click on save button
    Then  I should see the number of records increased by 1

  @delete-user
  Scenario: Verify that number of records after deleting the new user
    Given I should see number of records displayed
    When I search about the user i added with username as "sayed157"
    And  I click on delete button for the new user
    Then  I should see the number of records decreased by 1
