FROM openjdk:8-jdk-alpine

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-gateway.jar
ENTRYPOINT ["dockerize","-timeout","5m","-wait","http://cloud-config:8888/config-server/docker/master/logback-spring.xml","java","-jar","/api-gateway.jar","--spring.profiles.active=docker"]
EXPOSE 9187