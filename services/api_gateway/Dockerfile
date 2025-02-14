
FROM openjdk:17-jdk-slim

WORKDIR /app
COPY target/api_gateway-*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]