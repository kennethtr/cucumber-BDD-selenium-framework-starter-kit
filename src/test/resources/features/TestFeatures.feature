Feature: This is a sample feature file

  @SampleTest
  Scenario Outline: Verify that the user is able to login to the demo site and add a Student

    Given user logs in with username "<username>" and "<password>" logs in to demo site
    When user adds a student on Student Details page
    Then user sees the Enter Student Details page

    Examples:
      | username               | password    |
      |  admin                 | admin       |