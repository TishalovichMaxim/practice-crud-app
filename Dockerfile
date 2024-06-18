FROM amazoncorretto:17

WORKDIR /crud-app

ADD build/libs/CrudApp-0.0.1-SNAPSHOT.jar crud-app.jar

CMD ["java", "-jar", "crud-app.jar"]
