FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./


# Run the Spring Boot application with DevTools enabled
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix ./mvnw

RUN ./mvnw dependency:resolve

COPY src ./src

EXPOSE 8770

CMD ["./mvnw", "spring-boot:run"]