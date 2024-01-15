Feature: Validation of search result
  @Test
  Scenario Outline: verify the search functionality and validate the result
    Given visit the "<searchEngine>"
    When search for "<searchTerm>"
    Then verify the first search result with "<expectedResult>"


    Examples:
    |searchEngine|searchTerm|expectedResult|
   # |Google      |Java Tutorial|Java Tutorial|
    |Bing        |Selenium Tutorial|Selenium Tutorial|




