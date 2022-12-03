# microservices-workspace

This repo will help someone to get an understanding of the components needed in a microservices architecture.

Below are the details of the components & Spring Boot related technologies used for development in this repo :-

1. H2 - Embedded Relational Database

2. Tomcat - Embedded Servlet Container

3. Feign Client - Inter-service synchronous REST calls

4. Distributed Messaging - Active MQ - JMS Broker - http://localhost:9005/

5. Service Discovery - Eureka Client / Server - http://localhost:8761/

6. Config Server - Spring Cloud Config - http://localhost:8999/

7. API Gateway - Spring Cloud API Gateway - http://localhost:9187/

8. Circuit Breaker - Spring Cloud Resilience4j

9. Distributed Call Logs Tracing - Spring Cloud Sleuth

10. Zipkin Stream Server - http://127.0.0.1:9411/

11. Swagger

12. Docker Containers

13. Docker Compose

mvn clean package -DskipTests=true dockerfile:push
