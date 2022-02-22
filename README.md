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

    localhost:8080/sexCodes/
    localhost:8080/sexCodes/M
    localhost:8080/sexCodes/F

    localhost:8080/persons/1/addresses/
    localhost:8080/persons/2/addresses/

    localhost:8080/persons/search?sex=M&date=1900-07-01
    localhost:8080/persons/search1?sex=M&date=1900-02-15

    localhost:8080/addresses/search/?country=&prov=&city=Bedrock

    localhost:8080/groupCodes/

    localhost:8080/groupTypeCodes/

    localhost:8080/personAddress/1
    localhost:8080/personAddress/2




## Local Usage
You will need to have the _maven_pom_ project installed into your
local Maven repository or access to the GitHub repository version.

Maybe GitHub will allow anonymous access to the project repository
in the future.
