FROM openjdk:8
ADD target/bank-service.jar bank-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bank-service.jar"]