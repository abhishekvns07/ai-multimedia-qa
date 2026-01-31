# Use Java 21
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy built jar
COPY target/*.jar app.jar

# Expose backend port
EXPOSE 8080

# Run Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
