# Étape 1 : Build de l'application avec Maven (ou Gradle si tu préfères)
FROM maven:3.8.8-amazoncorretto-11 AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers de build Maven
COPY pom.xml .
COPY src ./src

# Compiler le projet
RUN mvn clean package -DskipTests

# Étape 2 : Image finale légère avec OpenJDK 11
FROM openjdk:11-jre-slim

# Créer un utilisateur non-root (optionnel mais recommandé)
RUN useradd -ms /bin/bash springuser

# Répertoire de l'application
WORKDIR /app

# Copier le .jar depuis l'étape de build
COPY --from=build /app/target/*.jar app.jar

# Donner les droits au user
RUN chown springuser:springuser app.jar
USER springuser

# Exposer le port 9000
EXPOSE 9000

# Commande de démarrage
ENTRYPOINT ["java", "-jar", "app.jar"]