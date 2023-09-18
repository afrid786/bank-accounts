# install java in docker image
FROM openjdk:17 as build

#maintainer info
MAINTAINER sekh afrid

# copy local application jar to docker file system
COPY target/bank-accounts-0.0.1-SNAPSHOT.jar bank-accounts-0.0.1-SNAPSHOT.jar

# command to run the application
ENTRYPOINT ["java", "-jar","/bank-accounts-0.0.1-SNAPSHOT.jar"]