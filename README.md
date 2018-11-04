# UUID generator service

This microservice exposes an end point and generates UUID for a user. 
I have written another microservice message-service (https://github.com/azam-akram/message-service) which exposes number of endpoints to keeps track of messages retrived to/from database. The message-service uses uuid-generator service to fetch uuid for newly created message in the system. Both services are discoverable through consul.

## How to run

### build whole project and run tests
```bash
gradlew clean build
```
I have written instructions about how to run this application with and withour docker container.
### Run application without docker container
The projects contains a **GeneratorApplication**, which starts Tomcat at port 8888. Call REST API mentioned in section (Rest Controller) below to generate the uuid.

### Build docker image
Use docker-compose to build uuid-generator image
```bash
docker-compose build
```

### Application Consul configuration
In order to make service discoverable in consul, I used spring cloud dependency and **@EnableDiscoveryClient**,
```java
@EnableDiscoveryClient
@SpringBootApplication
public class GeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
    }
}
```
and add *consul properties* in *bootstrap.yml* files
```yml
spring:
  application:
    name: uuid-generator
  cloud:
    consul:
      host: consul
      port: 8500
      discovery:
        enabled: true
        prefer-ip-address: true
        health-check-path: /health
        instance-id: ${spring.application.name}:${random.value}
        health-check-interval: 15s
```

### REST Controller

```
http://{host-ip}:8888/uuid-generator/v1/uuid
```




