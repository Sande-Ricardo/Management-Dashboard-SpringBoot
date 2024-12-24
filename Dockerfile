
FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon


FROM openjdk:17-jdk-slim
WORKDIR /md_restapi
COPY --from=build /md_restapi/build/libs/*.jar RestAPI.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "RestAPI.jar"]