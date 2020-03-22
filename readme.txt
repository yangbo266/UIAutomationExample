1.Features of this solution
 - 3 User Stories Test Classes with all Accept Critirials covered
 - POM (Page Object Model) pattern Java test code with Selenium, reusable, maintainable.
 - Unit test cases covers all POM classes
 - Java + Seleinum + Junit + Maven
 - Run all user stories test cases with single click via Junit Test Suite + Test Suite Runner class

2.User Manual
 a. Download source code bgptest.zip from https://drive.google.com/open?id=1JitlhYeT-PTsdqk1S2UmbfBUN4YPuhZ9
 b. Import project with Eclipse / IntelliJ
 c. Execute all user stories by right click /bgptest/src/test/java/test/suite/UserStoryTestSuite.java then "Run As" -> "JUnit Test"
 d. Execute all page unit test by right click /bgptest/src/test/java/test/suite/PageUnitTestSuite.java then "Run As" -> "JUnit Test"
 e. Another way to run above is right clikc /bgptest/src/test/java/test/runner/UserStoryTestMain.java or /bgptest/src/test/java/test/runner/PageUnitTestMain.java  then "Run As" -> "Java Application"
 f. Another way to run is using maven test command "mvn test"

3.Todo
 - Few test cases are not stable, need further tuning
 - Negetive test case to be created due to limited time frame
 - Centralize all input parameters into csv config file
 - Security test case to be created, e.g. SQL injection
 - Create test cases for different page size, e.g. page for laptop, page for mobile
 - Create report and send out automatically via email



