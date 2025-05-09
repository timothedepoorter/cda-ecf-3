# 🛒 E-commerce Microservices - Infrastructure Dockerisée

Ce projet met en œuvre une architecture microservices complète pour une application e-commerce, orchestrée à l’aide de **Docker Compose**. Elle inclut une base de données MySQL, un cache Redis, plusieurs services Spring Boot et un frontend React.

---

## 📦 Contenu des Services

### 🛢️ MySQL (Base de données relationnelle)

- **Configuration** :
    - `MYSQL_ROOT_PASSWORD` : mot de passe root
    - `MYSQL_DATABASE` : base de données à créer
    - `MYSQL_USER` / `MYSQL_PASSWORD` : utilisateur standard

### ⚡ Redis (Cache mémoire)

- **Sécurité** : mot de passe activé via `--requirepass`
- **Variable d'environnement** :
    - `REDIS_PASSWORD`

---

## ⚙️ Microservices Spring Boot

Chaque microservice est construit depuis une image Docker personnalisée à partir de son propre `Dockerfile`.

### 🔐 Authentication Service

- **Contexte** : `./server/authentication-service`
- **Variables** :
    - `PORT`, `DB_HOST`, `DB_PORT`, `DB_SCHEMA`, `DB_USER`, `DB_PASS`, `ACTIVE_PROFILE`

### 📚 Common Data Service

- **Contexte** : `./server/common-data-service`
- **Connexion à** :
    - **MySQL** (données)
    - **Redis** (cache)
- **Variables** :
    - `PORT`, `DB_*`, `REDIS_*`, `ACTIVE_PROFILE`

### 💳 Payment Service

- **Contexte** : `./server/payment-service`
- **Variables** :
    - `PORT`

### 🔍 Search Suggestion Service

- **Contexte** : `./server/search-suggestion-service`
- **Connexion à** :
    - **MySQL** et **Redis**
- **Variables** :
    - `PORT`, `DB_*`, `REDIS_*`, `COMMON_DATA_SERVICE_PORT`, `ACTIVE_PROFILE`

---

## 🌐 Frontend (React)

- **Contexte** : `./client`
- **Dépend de** :
    - Tous les microservices backend

---

## 🌐 Réseaux et Volumes

- **Réseau Docker partagé** : `app-network` (type `bridge`)
- **Volumes persistants** :
    - `mysql-data` : pour la base de données MySQL
    - `redis-data` : pour les données Redis

---

## 📄 Fichiers `.env`

Dans le contexte de l'ECF j'ai push les fichiers d'environnements sur le repo mais il ne s'agit pas d'une bonne pratique, en effet l'utilisation d'outil comme Vault pour stocker des secrets est fortement recommandé.

---

## Lancement du projet 🚀

```shell
docker-compose up -d # attention à bien se trouver à la racine du projet
```
