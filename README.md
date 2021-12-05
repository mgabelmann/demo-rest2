# demo-rest2
Spring Boot, Spring Data, REST and H2

## Project Information
Modularized Spring Boot project that uses Spring Data and Data REST.
Also provides Actuator information like:
    
    localhost:8080/actuator/health

Accessible endpoints using Data REST are:

    localhost:8080/helloworld

    localhost:8080/persons/

    localhost:8080/persons/1/
    localhost:8080/persons/2/

    localhost:8080/persons/1/addresses/
    localhost:8080/persons/2/addresses/

    localhost:8080/persons/search?sex=MALE&date=1900-07-01

    localhost:8080/persons/search1?sex=MALE&date=1900-02-15

## Local Usage
You will need to have the _maven_pom_ project installed into your
local Maven repository or access to the GitHub repository version.

Maybe GitHub will allow anonymous access to the project repository
in the future.
