# Etapa de build
FROM gradle:8.12.1-jdk17-corretto AS build

RUN mkdir -p /app/gradle

COPY settings.gradle /app
COPY build.gradle /app
COPY gradle /app/gradle
COPY gradlew /app/gradlew
COPY src /app/src

RUN chmod +x /app/gradlew

WORKDIR /app
RUN ./gradlew build -x test

FROM amazoncorretto:17

COPY --from=build /app/build/libs/service.tasks-0.0.1-SNAPSHOT.jar /app/app.jar

# Definir o diretório de trabalho
WORKDIR /app

# Expor a porta para acesso
EXPOSE 8081

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
