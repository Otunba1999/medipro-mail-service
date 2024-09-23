# Build stage
FROM eclipse-temurin:17-jdk-alpine AS builder
# Set working directory
WORKDIR /app
COPY . .
#Install depndency and build the application
RUN ./mvnw install -DskipTests
#Copy the built jar file in the package
COPY target/*.jar app.jar
# Package stage
#Use minimal JRE image for the final image
FROM eclipse-temurin:17-jre-alpine
# Set working directory in the final container
WORKDIR /app
#Copy the jar file from the builder stage
COPY --from=builder /app/app.jar .
#Expose port 8282 for the application
EXPOSE 8282
#Command to run the springboot application
ENTRYPOINT ["java", "-jar", "app.jar"]