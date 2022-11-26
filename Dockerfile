# syntax=docker/dockerfile:1
FROM openjdk:8
COPY . /
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/devopspractice-0.0.1-SNAPSHOT.jar"]