# Évaluation Spring :

# Sommaire
- [Introduction](#introduction)
- [Installation](#installation)
- [Architecture](#architecture)

# Introduction
C’est une application simple permettant à un utilisateur connecté d’ajouter, supprimer, 
mettre à jour ou de rechercher une tache à faire, classée ou pas par catégorie.  
Un utilisateur non authentifié aura accès à la page d’accueil du site avec pour exemple un 
ensemble de taches fictives.  
Une tache est définie par : Titre, Description, Date et une étiquette.  

# Installation
Le projet utilise la version 1.8 de Java et la version 2.5.3 de Spring.  
Dépendances :
- Spring Data JPA,
- Spring Validation,
- Thymeleaf,
- Spring web,
- Lombok,
- MariaDB Driver

## Architecture
<pre>
├── README.md
└── src
   └── main
      └── java
         └── fr.fms.Boardle
            ├── BoardleApplication.js
            ├── dao
               ├── TagRepository.js
               └── TaskRepository.js
            ├── entities
               ├── Tag.js
               └── Task.js
            └── web
               └── TaskController.js
         └── ressources
            ├── static.css
               └── bootstrap.min.css
            └── templates
               └── add_task.html
               └── board.html
               └── edit_task.html
               └── layout.html
</pre>

-----
