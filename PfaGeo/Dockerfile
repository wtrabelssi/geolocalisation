# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .

# Copy the Maven wrapper files
COPY mvnw .
COPY .mvn .mvn

# Make Maven wrapper executable
RUN chmod +x mvnw

# Download Maven dependencies (this will cache the dependencies if unchanged)
RUN ./mvnw dependency:go-offline

# Copy the application source
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# Expose the port the app runs on
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "target/PfaGeo-0.0.1-SNAPSHOT.jar"]
