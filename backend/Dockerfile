FROM openjdk:11-jre-slim-buster

COPY target/backend*.jar /opt/squad-backend.jar

EXPOSE 8080

CMD ["java","-jar","/opt/squad-backend.jar"]