FROM gradle:jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17
EXPOSE 8761
RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/wsclients-0.0.1-SNAPSHOT.jar /app/wsclients.jar

ENTRYPOINT ["java", "-jar","/app/wsclients.jar"]