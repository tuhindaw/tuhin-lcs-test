#GIT URL
git@github.com:tuhindaw/tuhin-lcs-test.git

Clone the project using below command
git clone git@github.com:tuhindaw/tuhin-lcs-test.git

#Spring boot JAR
This is a Spring Boot JAR (2.3.3.RELEASE) project that tests the endpoint of actual spring boot server application(git@github.com:tuhindaw/tuhin-projects.git) 
It has a test class named LcstestApplicationTests which will be executed during build and would validate the endpoint.

# Build/Run

This being a simple JAR application, can be executed just by below build command and it will execute the test class to test the endpoint functionality.


    Prerequisites : Your system need to have the following minimum requirements to create a Spring Boot
                    application:
                     Java 8
                     Gradle 4.x 
     Step1 : Make sure the spring boot server application is running. If not, run the application first. Then execute below
    ./gradlew build -> to build project

Or, can be executed the test class directly by executing the below command
    ./gradlew -Dtest.single=LcstestApplicationTests test
  


