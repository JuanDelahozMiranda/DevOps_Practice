# syntax=docker/dockerfile:1
FROM openjdk:8
COPY . /
EXPOSE 8181
ENTRYPOINT ["java","-jar","target/devopsPractice-0.0.1-SNAPSHOT.jar"]