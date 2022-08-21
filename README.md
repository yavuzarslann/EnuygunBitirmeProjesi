# EnuygunBitirme
This project is a test automation project that includes 2 Api test case and a web automation test case.
The first case involves API service tests of a business that sells fruits and vegetables. In the second case, it includes tests of some of the api services related to pets on swagger.io. Finally, the web case includes the test automation of the flight ticket purchase scenario on the enuygun.com website.

## Table of Contents
* [General Information](#general-information)
* [Technologies Used](#technologies-used)
* [Requirements](#requirements)
* [Setup](#setup)
* [Reporting](#reporting)
* [Acknowledgements](#acknowledgements)
* [Contact](#contact)

## General Information
In this project, a framework was created using object-oriented programming principles.</br></br>
In the EnuygunWebCase case, the `DriverSetup` class was created for driver creation. And a `config.yaml` file is created for the url and a `ConfigManager` class is created to read it. `Page` classes were created and locators and methods were created in them. In the test class, all of them were brought together and tests were written. Finally, a `Listener` class was created to log, and an extent report was used with this listener class in reporting.</br></br>
For ApiCase_1 and ApiCase_2 cases, test classes are created under `src/test/java/testScenarios`. In addition, a model for requests and framework was created under `src/main/java`. Under this framework, a `ConfigManager` class was created to read the `config.yaml` file, a `Endpoints` class for endpoints and a `Requests` class for requests.


## Technologies Used
- [Maven](https://mvnrepository.com) - Dependency Management
- [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/)
- [TestNG](https://testng.org/doc/)
- [Bonigarcia](https://github.com/bonigarcia/webdrivermanager) - WebDriver Manager
- [Project Lombok](https://projectlombok.org) - To make encapsulation
- [Yaml](https://yaml.org) - Config file format
- [Extent Reports](https://www.extentreports.com) - Reporting tool
- [Allure Report](https://qameta.io/allure-report/) - Reporting tool

## Requirements
In order to utilise this project you need to have the following installed locally:</br>
- Java 11
- Allure Report</br>

In EnuygunWebCase before running the tests, you need to create a file named `test-output` in the module directory on your computer so that the `Extent` report file can be generated.

## Setup
The project is broken into separate modules as ApiCase_1, Apicase_2 and EnuygunWebCase. Each of these modules can be utilised independently of the others using maven profiles.
</br></br>Bonigarcia dependency is used for browser driver in EnuygunWebCase module. With this dependency, a driver has been created for the Chrome browser in the DriverSetup.java class.
To run EnuygunWebCase test you need to go to `src/test/java/testScenarios` and run tests in the `BuyFlightTicket.java` class.</br></br>
To run ApiCase_2 you just need to go `src/test/java/testScenarios` and run tests in test classes.</br></br>
There is no working url in ApiCase_1. Tests are written as if there is a real url. That's why the tests don't run.
## Reporting
In the EnuygunWebCase case, Extent Reports was used for reporting. Before running the tests, you need to create a file named `test-output` in the module directory on your computer so that the report file can be generated. After creating this file, run the tests. The report file will be created under "test-output". The report is in html format and you can right click and open it in the browser.</br></br>
Allure Report was used to report ApiCase_1 and ApiCase_2 cases. Run the `allure serve` command from the terminal after running the tests to generate the report.
## Acknowledgements
This project was done as part of Enuygun Test Automation Bootcamp organized by [patika.dev](https://www.patika.dev/tr).
## Contact
Feel free to [contact me](www.github.com/yavuzarslann) 