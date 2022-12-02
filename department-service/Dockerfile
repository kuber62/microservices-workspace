FROM openjdk:8-jdk-alpine

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} department-service.jar
ENTRYPOINT ["dockerize","-timeout","5m","-wait","http://cloud-config:8999/config-server/docker/master/logback-spring.xml","-wait","tcp://jms-broker:61616","java","-jar","/department-service.jar","--spring.profiles.active=docker"]
EXPOSE 9001