FROM openjdk:8-jdk-alpine
COPY docker/id_rsa /root/.ssh/
COPY docker/config /root/.ssh/
RUN apk update; apk --no-cache add curl; apk add openssh; chmod 600 /root/.ssh/id_rsa
VOLUME /config
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cloud-config-server.jar
ENTRYPOINT ["java","-jar","/cloud-config-server.jar","--spring.profiles.active=docker"]
EXPOSE 8888