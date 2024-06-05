# Используем официальный образ Maven с JDK 22 для сборки проекта
FROM maven:3.8.8-openjdk-22 AS build

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файлы pom.xml и src/ в контейнер
COPY pom.xml .
COPY src ./src

# Запускаем команду Maven для сборки проекта
RUN mvn clean package -DskipTests

# Используем официальный образ OpenJDK 22 для запуска приложения
FROM openjdk:22-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем jar-файл из предыдущего этапа
COPY --from=build /app/target/your-app.jar .

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "your-app.jar"]
