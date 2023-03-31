# ProjetFinalP2Back
![diagrammeClassBestTrip(v1 2)](https://user-images.githubusercontent.com/127097635/228828717-df6b935d-cd22-4149-8f78-b41b87fb065d.jpg)


Creation des classes repository, controller classiquement.

Problème de sérialisation des données et mauvaise stratégie de récupération :
  Pour récupérer les guides d'un utilisateur par exemple, il y'a plusieurs facons:
      -Faire une requête directement
      -Utiliser l'attribut listeGuide dans la classe utilisateur
      
      
 On a commencé par récupérer les infos en faisant des requètes sur la table guide au lieu de passer par une requête qui récupère l'utilisateur pour ensuite accéder à l'attribut listGuide de l'utilisateur.
 
 Tests des requêtes avec postman
