FROM openjdk:11-jre-slim
EXPOSE 8080
ENV TZ=Asia/Seoul
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar" ,"/app.jar"]