Feature: Validation of search result
  @Test
  Scenario Outline: verify the search functionality and validate the result
    Given visit the "<searchEngine>"
    When search for "<searchTerm>"
    Then verify the first search result with "<expectedResult>"


    Examples:
    |searchEngine|searchTerm|expectedResult|
    |Google      |Java Tutorial|Java Tutorial|
    |Yahoo        |Selenium Tutorial|Selenium Tutorial|


  @Test
  Scenario: verify the search functionality for various set of data
    Given visit the google search engine
    When enter the search key from excel file
    Then verify the search result with expected outcome
