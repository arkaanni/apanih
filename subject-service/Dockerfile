FROM eclipse-temurin:11-jre
EXPOSE 8008:8008
RUN mkdir /app
# Assuming the jar file is already built
COPY /build/libs/subject-service.jar /app/subject-service.jar
ENTRYPOINT ["java", "-Xmx64m", "-jar","/app/subject-service.jar"]