FROM gradle AS builder
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootJar

FROM openjdk:17-jdk-alpine
EXPOSE 8080
VOLUME /tmp
COPY build/libs/conventioncenter-0.0.1-SNAPSHOT.jar /app/conventioncenter-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","./app/conventioncenter-0.0.1-SNAPSHOT.jar"]
