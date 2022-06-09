### Simple Steps to Run BooksMicroService Application:

* ##### First you need to run "mvn clean install" to install spring dependencies then run backend local server which is SpringBoot REST Services by running the root class of project "BooksMicroServiceApplication" just click on the green rectangle or right click on the class then Run "BooksMicroServiceApplication".

* ##### Now our backend service is running on Tomcat server on default port "8080" (you can change this port if it's already in use from a file "application.yml", but you need also to update angular base url to use new port).

* ##### My Spring boot application use H2 database it contains a schema and table structure which automatically will be created every time you run backend before application started.

* ##### I have created some test seed data in file "data.sql" you just need to uncomment it which located under directory "src/main/resources" which automatically will be executed before application started.

* ##### You can access database console GUI using url "http://localhost:8080/library/h2-console" using spring.datasource configuration values in "application.yml" file.

* ##### I have created all required REST API in this application in Postman as organized collections which you can find attached with my task solution zip file.

* ##### I hope that the task make you comfortable and happy, and I am ready for any modifications or feedback all acceptable for me thanks in advance. 

### All Technologies used to build this Application:

#### Backend Server Side:

* ##### Spring Boot - 2.6.7.RELEASE
* ##### JDK - 1.8
* ##### Spring Framework - 5.0.8 RELEASE
* ##### Hibernate - 5.2.17.Final
* ##### Spring Data JPA - 2+
* ##### Embedded Tomcat Server 

#### Development Tools:

* ##### Maven - 3.2+
* ##### IDE - IntelliJ IDEA // Spring boot development