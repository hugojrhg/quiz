FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

FROM openjdk:21-jdk-slim

EXPOSE 8080

COPY --from=build /target/quiz-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT [ "java", "-jar", "app.war" ]