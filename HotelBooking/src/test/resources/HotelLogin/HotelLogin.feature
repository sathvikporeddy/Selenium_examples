#Author: Vamshidhar Thonti
Feature: login
Description: This is related to user login page for Hotel booking application

Scenario: Check the heading of the login page
Given User is in login page
Then Check the heading of the page

Scenario: Successful login on entering valid credentials
Given User is in login page
When User enters valid username and password and clicks on login button
Then Hotel booking page should be displayed

Scenario: Failured login on entering either invalid username or invalid password
Given User is in login page
When User enters either invalid username or password
Then Error message should be displayed as invalid username or password

Scenario: Checking the gender of the Booking page
Given User is in login page
When selects the a radio button
Then does not show alert message

Scenario: Getting the info of the hyperlink
Given User is in login page
When user clicks on the hyperlink
Then user should be redirected to the success page

Scenario: Getting the values of the check boxes
Given User is in login page
When user checks multiple checkboxes
Then corresponding values should be displayed on the screen 

Scenario: Failured login on leaving username and password as blank
Given User is in login page
When User does not enter neither username nor password
Then Error message should be displayed as fields are empty