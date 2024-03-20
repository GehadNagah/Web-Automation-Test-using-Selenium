## Automated Testing Suite for Web Browsing

### Introduction
This repository contains automated test scripts written in Java using the TestNG framework to perform web browsing tests on different browsers (Chrome, Firefox, Edge). These tests aim to validate the functionality and behavior of a web application, specifically the Bing search engine.

### Prerequisites
- Java Development Kit (JDK) installed on your system
- Apache Maven installed on your system
- Chrome, Firefox, and Edge browsers installed on your system
- WebDriver executables for Chrome, Firefox, and Edge added to system PATH
- Maven dependency management system installed on your system.

### Setup
1. Clone this repository to your local machine.
2. Ensure that Java Development Kit (JDK) is installed on your system.
3. Ensure that WebDriver executables for Chrome, Firefox, and Edge are installed and added to the system PATH.
4. Ensure that Maven dependency management system is installed on your system.
5. Open the `pom.xml` file in the root directory of the cloned repository.
6. Add the following dependencies to the `pom.xml` file.

### Test Execution
1. Make Sure all dependencies exist .
2. Execute the test suite defined in the testng.xml file, which includes tests for Chrome, Firefox, and Edge browsers.

### TestNG XML Configuration (testng.xml)
The testng.xml file defines the test suite structure and parameters for executing the automated tests. Below is a breakdown of the XML configuration:

- Listeners: The <listeners> section specifies the listener classes to be used during test execution. In this case, it includes a custom listener class (base.Listeners) for specific actions on pass/fail events, as well as the HTMLReporter provided by TestNG for generating HTML reports.

- Test Cases: Each <test> element represents a test scenario to be executed. It contains parameters for the browser type (browser) and the website URL (website). The test cases are defined in the MyFirstTest class located in the testcase package.

### Test Scripts (MyFirstTest.java)
The MyFirstTest class contains automated test scripts written in Java using Selenium WebDriver and TestNG. These scripts perform various actions on the Bing search engine, such as entering search terms, navigating through search results pages, and validating search results.

### Custom Functions
The repository includes custom functions for common tasks performed during test execution. These functions are defined in separate Java classes and are utilized within the test scripts. Below are the key custom functions:

- LaunchBrowser: Opens a web browser and navigates to the specified website.
- Test: Performs a test scenario involving searching on a webpage and navigating through multiple pages of results.
- TearDown: Closes the web browser and resets the WebDriver instance.

### Test Reports
After executing the tests, TestNG generates HTML reports containing detailed information about test results, including pass/fail status, execution time, and screenshots (if configured). These reports provide valuable insights into the test execution process and can be used for debugging and analysis.

### Contributors
- Gehad Gendi
- s-gehad.nagah@zewailcity.edu.eg