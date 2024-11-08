FROM gradle AS builder
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootJar

FROM openjdk:17-jdk-alpine
EXPOSE 8081
VOLUME /tmp
ARG targethost=localhost:8080
ENV API_HOST=$targethost
COPY build/libs/project-auth-api-0.0.1-SNAPSHOT.jar /app/project-auth-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","./app/project-auth-api-0.0.1-SNAPSHOT.jar"]
