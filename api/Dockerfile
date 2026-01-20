# ===== Fase de build =====
FROM ubuntu:latest AS build
WORKDIR /app
RUN apt-get update && apt-get install -y openjdk-21-jdk maven
COPY . .
RUN mvn clean install

# ===== Fase de runtime =====
FROM amazoncorretto:21-alpine
WORKDIR /app
EXPOSE 8081
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
