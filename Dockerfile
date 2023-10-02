FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar servicios.jar
ENTRYPOINT ["java","-jar","/servicios.jar"]
EXPOSE 8080