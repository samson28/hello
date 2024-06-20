FROM openjdk:17-oracle
ADD target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar" , "app.jar"]