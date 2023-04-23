FROM openjdk:11.0-slim
VOLUME /tmp
ADD /target/*.jar /app/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/demo.jar"]
