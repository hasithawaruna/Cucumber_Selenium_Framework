## Test Automation Framework using Cucumber, Selenium & Java

The goal is to showcase various user interactions on the "https://conxillium.github.io/AddressManager/login" web application by creating automated tests that cover specific user flows. These tests will be implemented using Selenium, Cucumber and Java.

## Table of contents
- [Prerequisits]
- [Run Test]
- [Page Object Model(POM)]
- [Folder Structure]
- [Step Definition] 
- [Pages]
- [Feature files] 
- [Reporting]


## Prerequisits

```bash

Java JDK - v11
cucumber - v7.13
selenium - v4.11
Apache Maven 3.9.2

```

## Run Test

Use the below command to run the Cucumber test

```bash

 mvn test
 
```

## Page Object Model(POM)


The Page Object Model (POM) in Playwright is a design pattern used to organize web automation code. It abstracts web pages into classes, encapsulating their elements and actions. This approach enhances code maintainability, reusability, and readability, enabling efficient interaction with web elements while creating automated tests.


## Folder Structure

 
    ├── ...
    │
    ├── pages/                                    # Generic functionality for tests
    │   |
    │   ├── AddDataPage.java                      # Specific Locators & Functions of The Page                
    │   ├── HomePage.java                         # Specific Locators & Functions of The Page    
    │   ├── LoginPage.java                        # Specific Locators & Functions of The Page          
    │
    ├── utils/                                    
    │   |
    │   ├── Utilities.java                        # Common utilities used in the project
    │
    ├── hooks/   
    │   |
    │   ├── DriverInit.java                       # Driver Manager              
    │   ├── MyHooks.java                          # Cucumber Annotations
    │
    ├── runner/    
    │   |
    │   ├── TestRunner.java                       # Cucumber test run configurations
    │
    ├── stepdef/                                  # Step Definitions
    │   |
    │   ├── AddRecordStepDefinition.java                    
    │   ├── FilterStepDefinition.java     
    │   ├── LoginStepDefinition.java  
    │
    ├── features/                                  # Feature Files
    │   |
    │   ├── add.feature                   
    │   ├── filter.feature      
    │   ├── login.feature  
    │
    ├── target/   
    │         ├──cucumber-reports.html             #  Test report of the tests executed with screenshots
    │
    │── pom.xml                                    # Dependancy management




## Step Definition

"Step Definition" is a piece of code written in a programming language (such as Java, Ruby, etc.) that connects the plain text Gherkin steps (Given, When, Then) defined in feature files to the actual automation code. These step definitions define the behavior or actions that should be taken when each step in a scenario is executed.


## Pages

Page Object Model (POM), "Pages" refer to the representation of web pages as classes. Each web page is abstracted into a separate class, encapsulating its elements, actions, and related methods. This approach allows testers to interact with the web elements and perform actions on the page without directly dealing with the underlying HTML or implementation details. It promotes code modularity and makes test code more organized and maintainable.


## Feature files

A "Feature File" is a text document formatted in Gherkin language. It outlines how a software application should work, focusing on user interactions. It's the starting point to outline, structure, and detail test scenarios in a human-readable way before translating them into automated tests.


## Reporting

Once the execution is done you can find the HTML report under /Target folder

