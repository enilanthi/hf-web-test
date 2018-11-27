# hf-web-test

### Prerequisites:
> - Java 1.8
> - Maven
> - Git

### Execute hf-web-test via Commandline:
> - Clone the hf-web-test project from git. 
>   Command: ```git clone https://github.com/enilanthi/hf-web-test.git```
> - Move to hf-web-test directory. ```cd hf-web-test```
> - Simply trigger the execution using ```mvn clean test``` command

#### Additional Information:
> - The test execution will start parallely on Chrome and FireFox. For some reason if you want to disable the execution on either of the browsers, goto TestNG xml file (which can be found in ```hf-web-test\src\test\resources\testplan\testng.xml```), and comment-out the section for Chrome Test or FireFox Test.
> - ```NOTE: Apart from the 3 test cases already given, a 4th test is added to demonstrate the behavior on the failure.```
> - Logs will be generated under: ```hf-web-test\logs```
> - A comprehensive html report will be generated under: ```hf-web-test\target\extent-reports\test-output```. Note: This will also have screencapture(s) attached to the failed test(s)
> - You can also directly access these Screenshots under: ```hf-web-test\target\screenshots\browser```
- ```**NOTE: Compatible FireFox version: 61 or above```

### Features:
- [x] Logging all details of execution (Including all test steps, and failure details)
- [x] Capturing screenshots on failed tests
- [x] Generation of comprehensive HTML report 
- [x] Generating random values for insignificant test data. This feature is used in the scenario that registers new user (Test name: newUserRegistrationTest), to fill most of the details.
- [x] WebDriver factory
- [x] Encapsulation layers like test data, logic of tests, actions on web pages and so on
- [x] Configurator:
> - [x] Run tests in parallel mode. This is implemented using TestNG. The testng.xml file can be found under ```hf-web-test\src\test\resources\testplan```
> - [x] Ability to run tests for different browsers by configuring. Supports Chrome and FireFox. The required browser can be passed through testng.xml
> - [x] Ability to run tests for different environments(urls) by configuring. The URL too can be passed via testng.xml, as the parameter for tests
> - [x] Reading test data from external file. This feature is used in the checkout test (Test name: itemCheckoutTest), to input the quantity and the size of the dress.

### Third Party Library Usage
- ```Unit test runner - org.testng 6.14.3```
- ```Logging support - log4j 1.2.17```
- ```Automatic generation of test data - com.github.javafaker 0.16```
- ```Easily read test data from json file, and use it for data-driven support - com.googlecode.json-simple 1.1.1```
- ```Generate comprehensive html test report - com.aventstack 3.1.5```
