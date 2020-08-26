FROM openjdk:11-jre-slim

WORKDIR /app

# The application's jar file
ARG JAR_FILE=build/libs/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} code.jar

EXPOSE 9001/tcp

ENTRYPOINT ["java", "-jar", "/app/code.jar"]