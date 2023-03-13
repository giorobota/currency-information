FROM eclipse-temurin:19-jdk-alpine
EXPOSE 8080:8080
ADD "/build/libs/currency-information-0.0.1-SNAPSHOT.jar" "test.jar"
ENTRYPOINT ["java","-jar","/test.jar"]

#FROM gradle:7-jdk19 AS build
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle buildFatJar --no-daemon
#
#FROM openjdk:19
#EXPOSE 8080:8080
#RUN mkdir /app
#COPY --from=build /home/gradle/src/build/libs/*.jar /app/ktor-docker-sample.jar
#ENTRYPOINT ["java","-jar","/app/currency-information-0.0.1-SNAPSHOT.jar"]