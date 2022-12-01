FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} activemq-broker.jar
ENTRYPOINT ["java","-jar","/activemq-broker.jar","--spring.profiles.active=docker"]
EXPOSE 9005
EXPOSE 5672
EXPOSE 61613
EXPOSE 61614
EXPOSE 1883
EXPOSE 61616