# Stage 1: Build the JAR file
FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN apt-get install maven -y
# Build the JAR file
RUN mvn clean install -DskipTests


FROM openjdk:17-jdk-slim

EXPOSE 8081
COPY --from=build /target/CLIENT-CRUD-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

