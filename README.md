# Test application for T1 Consulting

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.kreuzfeuer.test.TestT1ConsultApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:
`mvn spring-boot:run`

## How to test this application
To check functionality, perform a POST request using the link - `http://localhost:8080/decomposition`, the body should not be an empty string (the application ignore spaces and controls characters).

The application receives a json object in the following format:

`{
"a": 5,
"c": 4,
"b": 1
}`