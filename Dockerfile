FROM openjdk:11

ARG JAR_FILE=ru.alpha.task2-1.0-SNAPSHOT.jar

ADD ${JAR_FILE} test_task.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "test_task.jar"]