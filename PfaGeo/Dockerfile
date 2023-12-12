# Use the official OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project and download dependencies
COPY pom.xml .

# Copy the Maven wrapper script and give execution permissions
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copy the application source
COPY src src

# Package the application
RUN ./mvnw package -DskipTests

# Expose port 8080
EXPOSE 8081

# Specify the command to run on container startup
CMD ["java", "-jar", "target/PfaGeo-0.0.1-SNAPSHOT.jar"]
