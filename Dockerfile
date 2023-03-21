FROM eclipse-temurin:19-jdk-alpine
EXPOSE 8080:8080
ADD "/build/libs/currency-information-0.0.1-SNAPSHOT.jar" "currency-information.jar"
ENTRYPOINT ["java","-jar","/currency-information.jar"]