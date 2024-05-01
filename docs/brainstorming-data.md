Spot
- id : INT
    à coder nous-même en l'absence de backend
    sera automatisé par le DBMS
- nom : STRING
    longueur limitée (50 char / qui peut s'afficher sur une ligne)
    1) renseigné par le user 2) categorie + lieu
- date : DATE
    format date natif dans Kotlin ?
- photos (urls) : Array<STRING> // une table à part 
    - id
    - url
    - filename ?
    - size ?
    - thumbnails ?
- coordonnées GPS : Object<STRING> (?)
    latitude : STRING
    longitude : STRING
- adresse : STRING
    (nom de rue/quartier, ville, pays)
- catégorie : STRING
    1 seule catégorie
    liste à choix multiples prédéfinis
- description : STRING
    limite de longueur (255 char) ?

Enrichiseements possibles
- author
- distance entre le mobile & le spot
- likes : INT
- hashtags : Array<STRING>

Infos complémentaires sur les photos ?
