FROM openjdk:17-alpine

VOLUME /tmp

EXPOSE 8885

ADD target/SpringBootDemo-0.0.1-SNAPSHOT.jar springbootapp.jar

ENTRYPOINT ["java", "-jar", "springbootapp.jar"]