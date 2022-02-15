Feature: Validating Amazon Appliction

  Scenario Outline: Validating Login of Amazon
    Given validate user hover mouse on SignIn option and click on signIn button
    When validate user enter userName and password from excel file "<sheetName>" and click on signIn button

    Examples: 
      | sheetName |
      | LoginCred |
