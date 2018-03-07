FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY target/discovery-server-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 1112
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/app.jar"]
