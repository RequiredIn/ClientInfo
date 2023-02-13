# ClientInfo

A basic project on 
Java8,
Hibernate,
Springboot,
Sprng Data JPA,
Server as Tomcat,
Use of Global Exception concept,
Hibernate Validations 

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
