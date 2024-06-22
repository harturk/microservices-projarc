FROM amazoncorretto:21-alpine AS build
RUN apk add --no-cache maven
WORKDIR /app
COPY . .

RUN mvn clean package

FROM openjdk:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]