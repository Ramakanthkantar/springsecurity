#FROM openjdk:11-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

FROM adoptopenjdk/openjdk11:alpine-jre
#ARG JAR_FILE=target/authenticationservices-0.0.1-SNAPSHOT.jar
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]