Feature: login

  @invalid
  Scenario Outline: login invalid
    Given I click explore now button
    When I provide phone number is "<phoneNumber>"
    Then I see error text is "<expected>"
    Examples:
      | phoneNumber     | expected                                                       |
      | 09855555559     | Số điện thoại bạn vừa nhập không hợp lệ. Vui lòng kiểm tra lại |
      #| 0926954813      |                                                                |
      #When I provide password is "<password>"




