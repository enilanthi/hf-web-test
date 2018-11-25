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
> - The test execution will start parellely on Chrome and FireFox. For some reason, if you want to disable the execution on either of the browser goto testng.xml (which can be found in ```hf-web-test\src\test\resources\testplan```), and comment-out the section for Chrome Test or FireFox test.
> - Logs will be generated under: ```hf-web-test\logs```
> - Comprehensive report html report will be created under: ```hf-web-test\target\extent-reports\test-output```. Note: This will also have screencapture(s) attached to the failed test(s)
> - You can also directly access these Screenshots under: ```hf-web-test\target\screenshots\browser```

### Features:
- [x] Logging all details of execution (Including test steps, and failure details)
- [x] Capturing screenshots on failed tests
- [x] Generation of comprehensive HTML report 
- [x] Generating random values for insignificant test data. This feature is used in the scenario that registers new user (Test name: newUserRegistrationTest), to fill most of the details.
- [x] WebDriver factory
- [x] Encapsulation layers like test data, logic of tests, actions on web pages and so on
- [x] Configurator:
>> - [x] Run tests in parallel mode. This is implemented using TestNG. The testng.xml file can be found under, ```hf-web-test\src\test\resources\testplan```
>> - [x] Ability to run tests for different browsers by configuring. Supports Chrome and FireFox. The required browser can be passed through testng.xml
>> - [x] Ability to run tests for different environments(urls) by configuring. The URL too can be passed via testng.xml, as the parameter for test
>> - [x] Reading test data from external file. This feature is used in the checkout test (Test name: itemCheckoutTest), to input the quantity and the size of the dress.

### Third Party Library Usage
