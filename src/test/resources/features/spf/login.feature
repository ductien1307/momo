Feature: SPF
  @Login
  Scenario Outline: Login
    When I login with "<email>" and "<password>"
    Examples:
      | email                 | password | expected |
      | ductien1307@gmail.com | Auto@123 | login    |
      | hlc1                  | 123456   | login    |
