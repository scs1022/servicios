FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY servicios-0.0.1-SNAPSHOT.jar servicios-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/servicios-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081
