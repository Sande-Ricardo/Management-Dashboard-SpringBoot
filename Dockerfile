FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/RestAPI-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} restapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "restapi.jar"]
