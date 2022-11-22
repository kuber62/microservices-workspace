FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} persistor-service.jar
ENTRYPOINT ["java","-jar","/persistor-service.jar"]
EXPOSE 9000