# Use Java 21
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

# Create a volume for temporary files
VOLUME /tmp

# Set working directory
WORKDIR /app

# Define argument for the JAR file
ARG JAR_FILE=target/*.jar

# Copy the JAR file into the container
COPY ${JAR_FILE} app.jar

# Expose Spring Boot port
EXPOSE 5000

# Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]
