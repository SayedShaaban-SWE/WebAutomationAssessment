# WebAutomationAssessment
----------------------------------------------------
## How to execute tests with cross-browsers and generat reports:
- Determine the name of the browser you need (crome - firefox - edge) in config.properties file.
- Run TestRunner class for the two scenarios or determine specific tage to run one scenario.
- If scenario is failed you will see screenshot taken and saved in screenshots folder.
- After execution go to target folder > cucumber-reports and open cucumber.html file with browser you like.
- Also you can see allure report follow the below steps:
    - Download and add allure frmework to systems environment variables.
    - After execution TestRunner class, open the console and run this command "allure serve".
    - You will see web browser page opened with report including (screenshot if scenario was failed).
