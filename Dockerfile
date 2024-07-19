#NOTE: when running docker add -p 8080:8080

FROM amazoncorretto:22-alpine
LABEL authors="Michael Gabelmann"

#create group and user to be more secure
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG DEPENDENCY=rest/target/exploded/
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

EXPOSE 8080

#run the main class
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "ca.mikegabelmann.demo2.Demo2Application"]
