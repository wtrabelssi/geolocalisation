# Use an official OpenJDK runtime as a base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/your-application.jar /app/your-application.jar

# Expose the port that your application runs on
EXPOSE 8081

# Define the command to run your application
CMD ["java", "-jar", "your-application.jar"]