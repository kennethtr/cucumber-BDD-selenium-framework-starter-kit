Feature: This feature file is to test the Bill payment flow of the MyRogers website

  @SampleTest
  Scenario Outline: Verify that a Rogers customer is able to pay outstanding Bills

    Given user logs in with username "<username>" and "<password>" logs in to demo site
    When user adds a student on Student Details page
    Then user sees the Enter Student Details page

    Examples:
      | username               | password    |
      |  admin                 | admin       |