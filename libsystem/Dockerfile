# Build stage
FROM openjdk:17
WORKDIR /app
EXPOSE 8000 
ADD target/libsystem-0.0.1-SNAPSHOT.jar /app/libsystem-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java", "-jar", "libsystem-0.0.1-SNAPSHOT.jar"]