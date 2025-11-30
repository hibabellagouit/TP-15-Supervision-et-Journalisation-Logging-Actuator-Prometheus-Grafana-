# TP15 – Supervision, Monitoring & Logging avec Spring Boot, Prometheus et Grafana

## 🎯 Objectifs du TP
Ce TP a pour objectif d’équiper une application Spring Boot avec un système complet d’observabilité, similaire à celui utilisé en production dans des environnements DevOps modernes.  
L’étudiant apprend notamment à :

- Collecter des métriques via **Spring Boot Actuator**
- Exporter ces métriques vers **Prometheus**
- Visualiser les données avec **Grafana**
- Mettre en place un **logging structuré**
- Superviser et détecter proactivement les incidents grâce à l’alerting

---

## 1️⃣ Initialisation du projet Spring Boot

Le projet est généré via Spring Initializr avec les dépendances nécessaires :
- Spring Web  
- Spring Boot Actuator  
- Micrometer Registry Prometheus  
- Lombok  

La structure projet inclut :
- Un contrôleur exposant un endpoint
- Un service simulant un traitement
- Une configuration pour le logging
- L’entrée principale de l’application

---

## 2️⃣ Activation et configuration de Spring Boot Actuator

**Actuator** expose divers endpoints permettant de suivre :
- La santé de l'application
- Les informations statiques (version, description…)
- Les métriques système et applicatives
- Les détails sur la JVM
- Les données exportées dans un format compatible Prometheus

Les endpoints principaux :
- `/actuator/health` – État de santé  
- `/actuator/info` – Informations personnalisées  
- `/actuator/metrics` – Liste des métriques  
- `/actuator/prometheus` – Export Prometheus  

Ces endpoints transforment l'application en système observable.

---

## 3️⃣ Mise en place du logging

La configuration du logging permet de :
- Ajuster les niveaux de journalisation
- Personnaliser le format d’affichage
- Stocker les logs dans un fichier dédié

Cela permet un suivi précis des traitements réalisés et une analyse aisée des erreurs en temps réel.

Les logs peuvent être consultés en continu via des outils comme `tail`.

---


## 4️⃣ Exportation des métriques vers Prometheus

Les métriques exposées par Actuator sont automatiquement compatibles avec Prometheus. Elles incluent notamment :
- Mémoire JVM utilisée  
- Compteurs de requêtes HTTP  
- Temps de traitement  
- Threading et Garbage Collection  

Il est également possible d’ajouter des métriques personnalisées afin d’étendre la supervision applicative.

---

## 5️⃣ Configuration de Prometheus

Prometheus est configuré pour interroger automatiquement le endpoint Actuator dédié aux métriques.

La configuration définit :
- L’intervalle de scraping
- Les cibles supervisées
- Les jobs de collecte

Grâce à son interface Web, il est possible d’exécuter des requêtes **PromQL** pour analyser les métriques (taux de requêtes, temps de réponse, mémoire, etc.).

---

![Uploading WhatsApp Image 2025-11-29 at 11.58.57 (1).jpeg…]()

## 6️⃣ Visualisation avec Grafana

Grafana permet :
- De connecter Prometheus comme source de données
- D’afficher les métriques sous forme de graphiques
- D’importer des dashboards existants
- De concevoir des tableaux de bord personnalisés

Les visualisations typiques incluent :
- Nombre de requêtes HTTP
- Latence moyenne
- Statistiques mémoire JVM
- Codes d’erreur
- État général des services

---

## 7️⃣ Mise en place d’un système d’alerting

Deux approches sont utilisées :

### 🔔 Alerting Prometheus
Permet de détecter :
- La chute du service
- Des pics d’erreurs HTTP
- Une latence anormalement élevée

### 🔔 Alerting Grafana
Permet de créer des alertes visuelles liées à :
- Des métriques de performance
- Des seuils critiques
- Des notifications (email, Slack, webhook…)

L’objectif est de détecter les incidents avant leur propagation.

---

## 8️⃣ Conteneurisation de l’infrastructure de supervision

Un fichier `docker-compose.yml` regroupe :
- L’application Spring Boot supervisée  
- Prometheus  
- Grafana  

Ce qui permet de lancer l’ensemble avec une seule commande.  
Cette approche facilite le déploiement de la stack en local ou en environnement de test.

---

## 9️⃣ Bonnes pratiques

| Aspect | Recommandations |
|--------|------------------|
| **Logs** | Centraliser via ELK ou Loki |
| **Métriques** | Utiliser une nomenclature cohérente |
| **Performance** | Adapter l’intervalle de scraping |
| **Sécurité** | Limiter l’exposition des endpoints sensibles |
| **Alerting** | Définir plusieurs seuils (warning, critical) |

---

## 🏁 Compétences acquises

À la fin de ce TP, l’étudiant maîtrise :
- L’observabilité d’une application Spring Boot
- L’utilisation d’Actuator pour exposer des métriques
- La collecte avec Prometheus
- La visualisation avec Grafana
- Le logging avancé
- L’alerting pour la supervision proactive
- Le déploiement d’une stack de monitoring via Docker

---

## 📦 Conclusion

Ce TP met en œuvre une chaîne d’observabilité complète, telle qu’on la retrouve dans les environnements DevOps modernes.  
L’étudiant est désormais capable de concevoir, analyser et superviser une application en conditions réelles.
