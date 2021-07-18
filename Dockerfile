FROM openjdk:8-jdk-alpine
ADD build/libs/vote-service-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java","-jar","/vote-service-0.0.1-SNAPSHOT.jar"]