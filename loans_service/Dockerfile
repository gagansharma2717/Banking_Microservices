# Start with base image containing Java Runtime
FROM openjdk:8-jdk-alpine as build

# Information around who maintains image
MAINTAINER gagansharma2717

# Add the application's jar to container
COPY target/loans_service-0.0.1-SNAPSHOT.jar loans_service-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java","-jar","/loans_service-0.0.1-SNAPSHOT.jar"]