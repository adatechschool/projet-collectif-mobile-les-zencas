# Esquisse

Application mobile de partage de lieux urbains visuellement insolites !

## Contributeur-ices

- Apolline DIAZ (https://github.com/apolline-diaz)
- Nicolas PERROTIN (https://github.com/nicotine189)
- Sam LAVAZAIS (https://github.com/SamLavazais)
- Chloé PELERIN (https://github.com/pchloe02)
- Eliana YEPEZ (https://github.com/Arteinsana7)
- Zachary JORIOT (https://github.com/maxlebro)

## Déroulement du projet

-   **Dates :** du 29 avril au 24 mai 2024
-   **Cadre :** Formation Ada Tech School
-   **Modalités :** projet collectif de 6 personnes

## Tech Stack

**Front-end (mobile) :**
- Android Studio
- Kotlin
- JetPack Compose

**Back-end :**
- Spring Boot
- Kotlin
- PostGreSQL


****************************
# MVP
Sont listées ici seulement les fonctionnalités qui ont pu être mises en place.

## Front-end
- Une vue pour afficher l'ensemble des lieux disponibles
  - Filtres et tris selon leurs caractéristiques
- Une vue détaillée pour chaque produit : toutes les infos + carrousel de photos
- Une vue pour ajouter un lieu
- Navigation entre les différentes vues via barre de navigation

## Back-end
- API REST (opérations CRUD) :
  - obtenir tous les lieux
  - obtenir un lieu en particulier
  - ajouter un lieu
  - supprimer un lieu
  - mettre à jour un lieu
- Architecture : entités, models, repositories, services, controllers
- Connexion à une DB PostGreSQL via ORM

****************************
## Développements futurs (?)

### Front-end
- Une vue register
- Une vue login
- Récupération des coordonnées GPS et calcul des distances avec chaque lieu
- Affichage des points sur une carte interactive

### Back-end
- Entité User et repo/services/controllers dédiés
- Authentification middleware
