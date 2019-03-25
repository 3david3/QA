# QA
QA CODE

Requirements 
 
Setup environment: Selenium, Maven, TestNG
 
Mandatory login to webpage: 
 http://openweathermap.org/current
username: ddaunay@gmail.com
password:  Test1234
 
 

 
Class: GetCallBBD
Path: Weather
 
Test Objective: 
A) Verify response from sample key request:  status Pass
 
B) Verify response from sample without key error expected: 401 status Pass
 
C) Verify response from sample without key error expected: 200 status Fail
 
D) Verify corresponding country is displayed correctly in the response according to selected city in the request (Loop insert 3 cities) expected matching country code status Pass
 
 ------------------------------------------------------------------------------------------------------------------------------
Class: Response_test
Path: Weather
 
Test Objective:            
A) Extracted data from Json object expected print of the Json data status Pass
 
B) Verify that the sunrise date is correct from the extracted data (Convert date to readable Java format). Expected date matching with current date status Pass
 
------------------------------------------------------------------------------------------------------------------------------
Class: Rectangle_Cities
Path: Box
 
Test Objective:            
A) Extracted data from Json object expected print of the Json data for minimum rectangle size status Pass
 
B) Verified nested data from weather parameter (Double loop to print all weather/ids. First loop locates all weather parameters. Second loop locate all Ids parameters). Expected find 5 ids status Pass.
 

Test Report  See report from testing results
Path:   Test-output/ index.html (Open with Web Browser) 
