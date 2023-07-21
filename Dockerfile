FROM openjdk:8-jdk-alpine-jre

VOLUME /tmp

EXPOSE 8885

ADD target/SpringBootDemo-0.0.1-SNAPSHOT.jar springbootapp.jar

ENTRYPOINT ["java", "-jar", "springbootapp.jar"]