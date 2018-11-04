FROM java:8

MAINTAINER  Muhammad Azam Akram <akram.muhammadazam@gmail.com>

EXPOSE 8080

ADD build/libs/uuid-generator-1.0-SNAPSHOT.jar /app/uuid-generator.jar

WORKDIR /app/

CMD java -jar uuid-generator.jar