# Activite-Pratique-N2---Developpement-Micro-service

# Bank Account Microservice

**Auteur : Hajar Elfallaki-Idrissi**  
**Projet : Activité Pratique N2 – Développement Microservice**  
**Description :** Ce projet est un microservice développé avec **Spring Boot** permettant de gérer des comptes bancaires.  


---

## 📌 Fonctionnalités

- Création, lecture, mise à jour et suppression des comptes bancaires (CRUD).  
- Gestion des données via **Spring Data JPA** et **H2 Database**.  
- API RESTful pour interagir avec les comptes.  
- Documentation interactive des API via **Swagger / OpenAPI**.  
- Utilisation de **DTOs et Mappers** pour exposer uniquement les informations nécessaires.  
- Possibilité d’utiliser **Spring Data Rest et projections** pour exposer certaines vues de données.

---

## 🛠️ Technologies utilisées

- **Java 17 / 19**  
- **Spring Boot**  
- **Spring Web**  
- **Spring Data JPA**  
- **H2 Database**  
- **Lombok**  
- **Swagger / Springdoc OpenAPI**  
- **Postman** (pour tester les API REST)  

---

## 📁 Structure du projet
<img width="587" height="919" alt="image" src="https://github.com/user-attachments/assets/a33122c6-6822-4acc-a6e2-13e7bbb71e8a" />

---
## 🚀 Démarrage du projet

# 🏦 Bank Account Service - Microservice REST API

## 📋 Description

Microservice de gestion de comptes bancaires développé avec **Spring Boot 3.5.7** et **Java 21**. 
Ce projet permet de créer, lire, modifier et supprimer des comptes bancaires via une API REST.

---

## 🚀 Technologies utilisées

- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **H2 Database** (base de données en mémoire)
- **Lombok**
- **SpringDoc OpenAPI 3** (Swagger UI)
- **Maven**
- **Java 21**

---

## 📁 Structure du projet

```
bank-account-service/
├── src/main/java/org/sid/bank_account_service/
│   ├── dto/
│   │   ├── BankAccountDTO.java
│   │   └── BankAccountResponseDTO.java
│   ├── entities/
│   │   └── BankAccount.java
│   ├── enums/
│   │   └── AccountType.java
│   ├── repositories/
│   │   └── BankAccountRepository.java
│   ├── service/
│   │   ├── AccountService.java
│   │   └── AccountServiceImpl.java
│   └── web/
│       └── AccountRestController.java
└── src/main/resources/
    └── application.properties
```

---

## ⚙️ Installation et Configuration

### 1. **Prérequis**

- Java 21 ou supérieur
- Maven 3.8+
- Git

### 2. **Cloner le projet**

```bash
git clone https://github.com/Hajarfallaki/Activite-Pratique-N2---Developpement-Micro-service.git
cd bank-account-service
```

### 3. **Configurer l'application**

Le fichier `application.properties` est déjà configuré :

```properties
spring.application.name=bank-account-service
spring.datasource.url=jdbc:h2:mem:account-db
spring.h2.console.enabled=true
server.port=8085
```

### 4. **Compiler le projet**

```bash
mvn clean install
```

---

## 🏃 Lancer l'application

```bash
mvn spring-boot:run
```

L'application démarre sur le port **8085**.

---

## 🧪 Tester l'API

### **Endpoints disponibles**

| Méthode | URL | Description |
|---------|-----|-------------|
| `GET` | `/api/bankAccount` | Récupérer tous les comptes |
| `GET` | `/api/bankAccount/{id}` | Récupérer un compte par ID |
| `POST` | `/api/bankAccount` | Créer un nouveau compte |
| `PUT` | `/api/bankAccount/{id}` | Mettre à jour un compte |
| `DELETE` | `/api/bankAccount/{id}` | Supprimer un compte |

### **Exemples avec cURL**

#### Créer un compte (POST)
```bash
curl -X POST http://localhost:8085/api/bankAccount \
  -H "Content-Type: application/json" \
  -d '{
    "balance": 10000.0,
    "currency": "MAD",
    "type": "CURRENT_ACCOUNT"
  }'
```

#### Récupérer tous les comptes (GET)
```bash
curl http://localhost:8085/api/bankAccount
```

#### Récupérer un compte par ID (GET)
```bash
curl http://localhost:8085/api/bankAccount/{id}
```

#### Mettre à jour un compte (PUT)
```bash
curl -X PUT http://localhost:8085/api/bankAccount/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "balance": 15000.0,
    "currency": "EUR",
    "type": "SAVING_ACCOUNT"
  }'
```

#### Supprimer un compte (DELETE)
```bash
curl -X DELETE http://localhost:8085/api/bankAccount/{id}
```

---

## 📊 Tester avec Postman

### Exemple de requête POST

<img width="850" height="317" alt="Postman POST Request" src="https://github.com/user-attachments/assets/7e3d32b5-14c8-4412-9f2b-c67a986775a1" />

**Corps de la requête (JSON)** :
```json
{
  "balance": 5000.0,
  "currency": "MAD",
  "type": "CURRENT_ACCOUNT"
}
```

**Réponse attendue (201 Created)** :
```json
{
  "id": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
  "createdAt": "2025-11-17T00:00:00.000+00:00",
  "balance": 5000.0,
  "currency": "MAD",
  "type": "CURRENT_ACCOUNT"
}
```

---

## 📚 Documentation API avec Swagger

### Accéder à Swagger UI

Ouvre ton navigateur à l'adresse :

```
http://localhost:8085/swagger-ui.html
```

Tu peux visualiser et tester toutes les APIs directement depuis l'interface Swagger.

### Documentation OpenAPI JSON

```
http://localhost:8085/api-docs
```

---

## 🗄️ Console H2

Pour accéder à la console H2 (base de données) :

```
http://localhost:8085/h2-console
```

**Paramètres de connexion** :
- **JDBC URL** : `jdbc:h2:mem:account-db`
- **Username** : `sa`
- **Password** : _(laisser vide)_

---

## 📸 Screenshots

### 1. Swagger UI
<img width="1894" height="1013" alt="Capture d&#39;écran 2025-11-16 220737" src="https://github.com/user-attachments/assets/ef26159a-77b2-487c-a029-330a2f2d9854" />
<img width="1332" height="338" alt="Capture d&#39;écran 2025-11-16 215216" src="https://github.com/user-attachments/assets/9ab71763-719b-4506-9476-0e6e6f2ff277" />


### 2. Test avec Postman
<img width="1684" height="1008" alt="Capture d&#39;écran 2025-11-16 212255" src="https://github.com/user-attachments/assets/250541f0-3d55-4fdb-9216-28cd93e51ffd" />

### 3. Console H2
<img width="890" height="716" alt="Capture d&#39;écran 2025-11-16 171400" src="https://github.com/user-attachments/assets/8cc77b3e-52a4-47ec-bf61-55eaa637d520" />
<img width="1538" height="910" alt="Capture d&#39;écran 2025-11-16 171456" src="https://github.com/user-attachments/assets/91a572aa-d830-4bba-84de-32f9972954c5" />
<img width="1557" height="934" alt="Capture d&#39;écran 2025-11-16 194518" src="https://github.com/user-attachments/assets/e15419f5-3cad-4aaa-9115-afb2b45481e1" />


### 4. Résultats des tests
<img width="1857" height="972" alt="Capture d&#39;écran 2025-11-17 002017" src="https://github.com/user-attachments/assets/7e43d4ee-6380-431e-8d0f-192c4f12994b" />
<img width="1404" height="825" alt="Capture d&#39;écran 2025-11-17 002023" src="https://github.com/user-attachments/assets/361cc735-d857-4b31-8e65-f7aea342b362" />


---

## 🎯 Fonctionnalités

- ✅ CRUD complet sur les comptes bancaires
- ✅ Validation des données avec DTO
- ✅ Documentation automatique avec Swagger/OpenAPI
- ✅ Base de données H2 en mémoire
- ✅ Architecture en couches (Controller, Service, Repository)
- ✅ Utilisation de Lombok pour réduire le code

---

## 🔧 Configuration avancée

### Changer le port du serveur

Modifier dans `application.properties` :
```properties
server.port=8085
```

### Utiliser une base de données persistante

Remplacer dans `application.properties` :
```properties
spring.datasource.url=jdbc:h2:file:./data/account-db;AUTO_SERVER=TRUE
```

---

## 👨‍💻 Auteur

**Hajar Fallaki**



---

## 📝 Licence

Ce projet est sous licence MIT.

---






