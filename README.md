# UUID generator service


## How to run

### build whole project and run tests
```bash
gradlew clean build
```

### Run application without docker container
Run GeneratorApplication, which starts Tomcat at port 8888. Then call REST APIs mentioned in section (Rest Controller) below.

### Build docker image
In this project, I just build the uuid-generator image and in other project (message-service), I run consul, uuid-generator and message-service.
Use docker-compose to build uuid-generator image
```bash
docker-compose build
```

### Application Consul configuration

In order to make service discoverable in consul, use spring cloud dependency and used @EnableDiscoveryClient,
```java
@EnableDiscoveryClient
@SpringBootApplication
public class GeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
    }

}
```

and add consul properties in bootstrap.yml files
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




