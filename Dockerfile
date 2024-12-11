# Stage 1: Build the JAR file
FROM maven:3.9-openjdk-17 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create a lightweight image with the built JAR
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/CLIENT-CRUD-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
