FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD authentication-0.0.1-SNAPSHOT.jar app.jar
ADD hibernate.cfg.xml ../opt/sourcecode/config/authentication/hibernate.cfg.xml
EXPOSE 9000
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/app.jar"]
