FROM java:8
VOLUME /tmp
ADD authentication-0.0.1-SNAPSHOT.jar app.jar
ADD hibernate.cfg.xml ../opt/sourcecode/config/authentication/hibernate.cfg.xml
RUN bash -c 'touch /app.jar'
EXPOSE 9000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]