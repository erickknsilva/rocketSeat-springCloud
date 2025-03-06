# Etapa de build
FROM gradle:8.12.1-jdk17-corretto AS build

# Criar diretório /app/gradle se não existir
RUN mkdir -p /app/gradle

# Copiar arquivos necessários para a construção do projeto
COPY settings.gradle /app
COPY build.gradle /app
# Certifique-se de que a pasta 'gradle' existe no seu projeto local
COPY gradle /app/gradle
# Copiar o arquivo gradlew
COPY gradlew /app/gradlew
COPY src /app/src

# Garantir que o gradlew tenha permissões de execução
RUN chmod +x /app/gradlew

# Definir o diretório de trabalho e rodar o build
WORKDIR /app
RUN ./gradlew build

# Etapa final para a imagem com Amazon Corretto
FROM amazoncorretto:17

# Copiar o JAR gerado da etapa de build
COPY --from=build /app/build/libs/service.main-0.0.1-SNAPSHOT.jar /app/app.jar

# Definir o diretório de trabalho
WORKDIR /app

# Expor a porta para acesso
EXPOSE 8888

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
