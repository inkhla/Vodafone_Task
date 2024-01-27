# Vodafone Task  
## Overview This repository contains the solution for the Vodafone Task. It includes details on how to set up the project, run tests, and any additional information related to the task.
 ## Table of Contents  
- [Setup](#setup) - 
- [Running Tests](#running-tests)
- [Project Structure](#project-structure) 
 - [License](#license) 
 ## Setup To set up the project locally, follow these steps: 
 1. Clone the repository: 
 ```bash
  git clone https://github.com/inkhla/Vodafone_Task.git
  ```
  2. Install all dependencies in the pom.xml file 
   ## Running Tests:
   1. For running the UI testing need to use the **AddThreeProductsToCartRunner** runner class:
		   will be found in this path : *src/test/java/com/tests/eshop_add_to_cart/AddThreeProductsToCartRunner.java*	
 2. For running the API testing need to use the **TestSuiteRunner** runner xml file:
			will be found in this path: *src/test/java/com/API/TestSuiteRunner.xml*
## Project Structure:
```
|- Documents
	|- bug_report
		|- YallKora_Bug_Report.xlsx
	|- ideas_and_prioritization
		|- List of Test Ideas and Prioritization_YallaKora_Mobile App.pdf
		
|- resources
	|- execution_record
		|- Execution_record.mp4
	|- test_cases_API
		|- test_cases_API.xlsx
	|- test_data
		|- test_data.xlsx
	|- webDriver
		|- chromedriver.exe

|- src
	|- main
		|- java
			|- org.example
				|- api_models -> contains the models to store and mapp the API resposne in it
					|- Entries.java
					|- PublicAPI.java
				|- page_object -> contains UI page objects for all pages 
					|- cart_page
						|- CartPage.java
					|- home_page
						|- HomePage.java
					|- login_page
						|- LoginPage.java
					|- product_page
						|- ProductPage.java
				|- Utils
					|- Config
						|- data
							|- ExcelUtils.java -> handles read from excel file
						|- properties
							|- credentials.properties -> contains credentials of vodafone e-shop user
						|- service
							|- PropertiesReader.java -> handle read from .properties file
	
	|- test
		|- java
			|- com
				|- API
					|- setup -> contains the setup class for api test
						|- APISetUp.java
						|- ExcelDataProvider
					|- tests -> contains test classes for api
						|- EntriesTests.java
						|- RandomTests.java
					|- TestSuiteRunner.xml -> Runner xml for API tests
				|- tests
					|- eshop_add_to_cart
						|-AddThreeProductsToCart.feature -> feature file contains the scenarios
						|- AddThreeProductsToCartRunner.java -> Cucumber runner class
						|- AddThreeProductsToCartStepDefinitions.java -> tests step definition class
					|- HooksHandler.java -> Hooks handler class for setup the cucumber test
		|-resources
			|- reports -> contains the test report of cucumber and rest assured tests
				|- API_test_report.html
				|- UI_test_report.html
```
## License:

1. In UI automation testing used:
	* Selenium
	* Cucumber
	* Junit
	* Vodafone e-shop original website 
2. In API automation testing used:
	* Rest Assured
	* TestNG
	* Jakson
	* Apache POI API
	* https://github.com/davemachado/public-api.git free API
