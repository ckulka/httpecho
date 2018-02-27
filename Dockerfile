FROM openjdk:8-alpine

COPY target/*.jar http-echo.jar

CMD ["java", "-jar", "http-echo.jar"]