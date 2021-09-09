Hagar Adel - JumiaTask
Sample application viewing customer List and do some filters

-------------------------------------------------------------------------
Table of Contents: 
-General info
-Technologies
-Setup

-------------------------------------------------------------------------
-General info
Jumia application view a list of customers with there id,name and phone and you could apply filter to the list by:
 - Country : use the country name to get the country code throw DB country table and get the country customer list.
 - Valid : validation for each number based on the given regex for each country.
 - Country Code: you could filter the customer list based on there code.
 - Phone Number: get the customer info using customer phone.

-------------------------------------------------------------------------
-Technologies
Project is created with:
Backend:
-Java 
-JDK: 1.8 Encoding: UTF-8
-Springboot framwork 2.5.4
-Junit : 4.12
-SQLLite 3

Frontend:
Angular CLI: 10.1.6
Node: 14.17.5

-------------------------------------------------------------------------
-Setup
1. Start the backend Jumia jar  /Jumia/Jumia/target/Jumia-2.5.4.jar
2. Start the frondenf /Jumia/JumiaUI
   - Download Node Js and Angular CLI 10.1.6
   - Open the JumiaUI in the Visual Studio Code
   - Open new Terminal 
   - run : npm install
   - run: ng serve
   - on chrome hit the URL: http://localhost:4200/


