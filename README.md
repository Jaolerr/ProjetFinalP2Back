# ProjetFinalP2Back

Voici le diagramme de classe de notre projet: 
[diagrammeClassBestTrip(v2)](https://user-images.githubusercontent.com/127097635/230321365-7611da73-e59b-40f3-8155-b99365678739.jpg)

Voici le diagramme de classe de notre projet:
 MODEL MCD : 
![MODEL MCD](https://user-images.githubusercontent.com/127097584/231392666-e41ea20c-2958-443b-aeda-c145eb7c103b.png)

# Resumé
Dans un premier temps nous avons réaliser la creation des classes répository, controller classiquement.

## Test
Tests des requêtes avec postman

Creation des premiers tests d'insertion d'utilisateur + modification du service pour les compagnies pour bien différencier le type de compagnie. 

## Jenkins
Mise en place de la configuration Jenkins en début de projet

# Problème rencontré
En début de projet :
Problème de sérialisation des données et mauvaise stratégie de récupération :
  Pour récupérer les guides d'un utilisateur par exemple, il y'a plusieurs façons:
      -Faire une requête directement
      -Utiliser l'attribut listeGuide dans la classe utilisateur
           
 On a commencé par récupérer les infos en faisant des requètes sur la table guide au lieu de passer par une requête qui récupère l'utilisateur pour ensuite accéder à l'attribut listGuide de l'utilisateur.
 
 
