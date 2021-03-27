# Linker 
App to manage tasks, notes etc. Something is like Evernote.

Technologies: 
- Microservice architecture: Spring Boot 2.4, Spring Cloud 2020, Resilience4j, Feign;
- Secure: Spring Security and tokens ;
- Messaging: Kafka
- Database: Liquibase, PostgreSQL, File system for pages
- Build: Maven, Docker 
- Other: MapStruct ;

Future
- UI on React


##### Requests

- http://localhost:8082/account/swagger-ui/index.html 
- watch -n 0.1 curl http:/localhost:8082/task-ws/sample
- docker run -d -p 9411:9411 openzipkin/zipkin:2.23
- -pl task spring-boot:build-image -DskipTests -am -f pom.xml

