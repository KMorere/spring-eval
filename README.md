# Évaluation Spring :

# Sommaire
- [Introduction](#introduction)
- [Installation](#installation)
- [Architecture](#architecture)

# Introduction
Boardle est une application simple de gestion de tâches utilisant le principe d'un tableau de Kanban.  
Elle permettant à un utilisateur connecté d’ajouter, supprimer ou modifier une tâche.  
Un utilisateur non authentifié aura accès à la page d’accueil du site.  
L'affichage du tableau permet également de filtrer à partir des étiquettes ou bien d'une barre de recherche.  
Une tache est définie par : Titre, Description, Date et une Étiquette.  

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
