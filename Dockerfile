FROM amazoncorretto:17-alpine3.18-jdk

RUN apk update && \
    apk add --no-cache maven bash

WORKDIR /app/fpl

COPY pom.xml .
COPY src ./src

SHELL [ "/bin/bash" ]

RUN mvn package

ENTRYPOINT [ "java", "-jar", "./target/fpl-1.0-SNAPSHOT.jar" ]
