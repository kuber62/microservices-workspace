FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} activemq-broker.jar
ENTRYPOINT ["java","-jar","/activemq-broker.jar"]
EXPOSE 9005 61616