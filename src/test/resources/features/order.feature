Feature: MoMo Order
  Scenario: Order
    Given I click explore now button
    When I provide phone number is "0926954813"
    Then I provide password is "123456"
    Then I search store with keyword is "Highlands Coffee"
