FROM openjdk:21-jdk
COPY build/libs/weather-0.0.1-SNAPSHOT.jar weather-0.0.1-SNAPSHOT.jar
COPY cacerts /usr/java/openjdk-21/lib/security/cacerts
ENTRYPOINT ["java", "-jar", "weather-0.0.1-SNAPSHOT.jar"]

