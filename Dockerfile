FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY servicios.jar servicios.jar
ENTRYPOINT ["java","-jar","/servicios.jar"]
EXPOSE 8081
