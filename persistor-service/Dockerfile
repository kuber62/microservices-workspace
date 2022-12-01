FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} persistor-service.jar
ENTRYPOINT ["java","-jar","/persistor-service.jar","--spring.profiles.active=docker"]
EXPOSE 9000