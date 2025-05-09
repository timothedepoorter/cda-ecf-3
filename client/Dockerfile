# Étape 1 : build de l'app React avec Node.js 14
FROM node:14-alpine AS build

# Crée un dossier de travail
WORKDIR /app

# Copie les fichiers nécessaires
COPY package.json yarn.lock ./

# Installation des dépendances
RUN yarn install

# Copie le reste de l'application
COPY . .

# Build de l'app React
RUN yarn build

# Étape 2 : NGINX pour servir le frontend
FROM nginx:alpine

# Copie le build dans le dossier web de nginx
COPY --from=build /app/build /usr/share/nginx/html

# Expose le port 3000
EXPOSE 3000

# Démarre nginx
CMD ["nginx", "-g", "daemon off;"]