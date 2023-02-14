# ClientInfo
============================================================================
Project :- 
REST API that allows for creating, updating and searching for a client. 
 
A client should have the following fields, fields marked with * a mandatory
Client 
  First Name*
  Last Name*
  Mobile Number
  ID Number*
  Physical Address 
 
When a client is created or updated the following fields should be validate
ID Number
1.	Must be a valid south African ID number
2.	No Duplicates ID numbers
Mobile Number
1.	No duplicate mobile numbers
 
When validation fails an appropriate response should be provided.
 
==================================================================
A basic project on 
Java8,
Hibernate,
Springboot,
Sprng Data JPA,
Server as Tomcat,
Use of Global Exception concept,
Hibernate Validations 
====================================================================
POST :- 
http://localhost:8080/api/client/save
payload:-

{
    "idNumber": "031125100209",
    "firstName": "Best",
    "lastName": "Test",
    "physicalAddress": "johannesburg",
    "mobileNumber": 4233534537
}

GET:-
http://localhost:8080/api/client/getAll

GET:-
http://localhost:8080/api/client/getClient/{FirstName or ID Number or Phone Number}
