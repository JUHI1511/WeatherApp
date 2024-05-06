FROM openjdk:17

COPY target/demo.jar .

EXPOSE 8080

ADD target/demo.jar demo.jar

ENTRYPOINT ["java","-jar","demo.jar"]

