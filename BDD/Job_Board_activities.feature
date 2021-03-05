@JobBoard_activity
Feature: Application Alchemy Jobs

@JobBoardactivity_1
Scenario: Create a new user
    Given Open Browser
    When Open job board system application
    Then Login to the application with "Username" and "Password"  
    Given Locate left hand menu and click on Users
    When Find Add New button and click on it
    Then Fill all necessary detail and click Add New User button
    And Verify user has been created
    And Close the browser

@JobBoardactivity_2  
Scenario: Searching for jobs using XPath
    Given Open Browser
    When Open Alchemy job site and navigate to Jobs Page
    Then Search for jobs
    And Filter Full-Time job
    And List the job filtered and print title in console
    And Apply for job
    And Close the browser
    
@JobBoardactivity_3
Scenario: Posting a job using parameterization
    Given Open Browser
    When Open Alchemy job site and navigate to post job page
    Then User enters "amrutha00178@gmail.com" and "SDET-Training-BDD-Cucumber2" and "Bangalore" and "SDET Training BDD Class" and "https://70089/jobs" and "IBM"
    And Click on Submit
    And Go to jobs page
    And Verify newly added job is shown in job listing page
    And Close the browser
    
@JobBoardactivity_4
Scenario Outline: Using Examples table to post a job
     Given Open Browser
     When Open Alchemy job site and navigate to post job page
     Then User enters "<Emailid>" and "<JobTitle>" and "<Location>" and "<Description>" and "<Url>" and "<CompanyName>"
     And Click on Submit
     And Go to jobs page
     And Verify newly added job is shown in job listing page
     And Close the browser
  
Examples:
| Emailid            | JobTitle        | Location  | Description   | Url          | CompanyName |
| Kris8961@gmail.com | SDET-Trainer678 | Bangalore | SDET Training | https://3697 | IBM         |   