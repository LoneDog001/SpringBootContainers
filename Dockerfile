FROM openjdk:18-jdk-alpine
EXPOSE 8080
ADD target/SpringBootDemo-0.0.2-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]