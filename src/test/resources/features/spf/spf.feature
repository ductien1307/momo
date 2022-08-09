Feature: SPF

  @Location
  Scenario Outline: Location
    Given I set location is "<location>"
    #Then  I see page is "<expected>"
    Examples:
      | location              | expected |
      | 55C Nguyễn Đình Chiểu |          |

  @Login
  Scenario Outline: Login
    When I login with "<email>" and "<password>"
    Examples:
      | email                 | password | expected |
      | ductien1307@gmail.com | Auto@123 | login    |
      #| hlc1                  | 123456   | login    |

  @Search
  Scenario Outline: Search Store
    When I go to most order
    #When I search store with keyword is "<storeName>"
    Examples:
      | storeName                       |
      | Highlands Coffee - Lê Trọng Tấn |

  @Order
  Scenario Outline: Order
    When I order with product name is "<productName>"
    Examples:
      | productName     |
      | Freeze trà xanh |
      #| Phin Sữa Đá |