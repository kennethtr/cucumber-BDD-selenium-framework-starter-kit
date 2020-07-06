# cucumber-BDD-selenium-framework-starter-kit
Cucumber selenium framework starter kit

This Maven project is intended to help fellow QA testers/analysts get started with a robust test framework to  automate test cases for Web applications.

The framework is Cucumber-BDD based and uses Selenium, Java libraries and incorporates Page Object Model.

Java and Maven are pre-requisites.

Features include:

 - Support for all major web browsers (Windows + MacOS)
 - Support for reporting (using Extent Reports)
 - Support for capturing screenshots
 - Utilities class which has resuable methods that help perform common web actions.
 - Support for Logging
 
 A feature file to test a basic test flow for the website - https://twhyderabad.github.io/demo_site/ has been included. 
 This is only to demonstrate that the framework supports testing web applications such as the one mentioned.
 
 Order of the flow is as follows (file names as in the project are mentioned below)
 
Feature File (TestFeatures.feature) -> Glue File (StepsGlue) -> Interface  (TestStepsService)  -> Implementation (TestStepsImpl) -> Page Class 
(any one of the 3 classes under "..//ui//pages)

The above files can be used to create your own test flows for your web application.

Features to be implemented in the future include:

- Dependency Injection
- Support for Appium
- Support for Rest API Services testing 
 
 Please feel free to add improvements to the project and thank you for checking this out.
 
 
 --
 Kenneth
 

