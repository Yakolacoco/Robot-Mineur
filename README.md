# 🤖 Simulation de Robot Mineur — Java

## 📌 Description générale

Ce projet est une **simulation en Java (console)** mettant en scène un **robot mineur** évoluant sur un **plateau de jeu** représenté par une grille.  
Le robot doit explorer le plateau, **collecter du minerai**, **éviter les obstacles**, gérer son **énergie**, puis **déposer le minerai dans un entrepôt unique** afin de gagner la partie.

Le projet met en œuvre les principes fondamentaux de la **programmation orientée objet (POO)** : abstraction, héritage, composition et séparation des responsabilités.

---

## 🎯 Objectifs du projet

- Modéliser un robot avec un état et des comportements
- Créer un plateau composé de différents types de cases
- Implémenter des interactions entre le robot et les cases
- Gérer une boucle de jeu interactive en console
- Mettre en place une condition de victoire

---

## 🧱 Architecture du système

### 1️⃣ Robot

Le robot est l’entité contrôlée par l’utilisateur.

**Attributs :**
- Nom
- Position (x, y)
- Quantité de minerai transportée
- Capacité maximale de transport
- Niveau d’énergie

**Méthodes principales :**
- `deplacer(int x, int y)`
- `collecter()`
- `deposer()`
- `reposer()`
- `afficherEtat()`

---

### 2️⃣ Abstraction des cases

Toutes les cases du plateau héritent d’une abstraction commune (`Case`).

**Méthodes communes :**
- `char afficher()`
- `void interagir(Robot robot)`
- `boolean estFranchissable()`

#### ⬜ Case Vide
- Symbole : `.`
- Franchissable
- Aucune interaction particulière

#### ⛏️ Mine
- Symbole : `M` (puis `.` une fois épuisée)
- Contient une quantité limitée de minerai
- Permet au robot de collecter du minerai

#### 🚧 Barrière
- Symbole : `B`
- Non franchissable
- Bloque le robot

#### 🏭 Entrepôt
- Symbole : `E`
- Permet de déposer le minerai
- Stocke le total de minerai collecté

---

### 3️⃣ Plateau

Le plateau est une **grille rectangulaire** de cases.

**Attributs :**
- Largeur et hauteur
- Tableau 2D de cases
- Référence vers le robot
- Référence vers l’entrepôt

**Méthodes principales :**
- `initialiserPlateau()`
- `obtenirCase(int x, int y)`
- `estValide(int x, int y)`
- `estFranchissable(int x, int y)`
- `afficherPlateau()`

---

### 4️⃣ Gestion du jeu

La classe de gestion du jeu contrôle la **boucle principale** et les interactions utilisateur.

**Commandes disponibles :**
- `haut`
- `bas`
- `gauche`
- `droite`
- `repos`
- `etat`
- `quitter`

**Fonctionnalités :**
- Lecture des commandes utilisateur
- Déplacement du robot
- Interaction avec les cases
- Vérification des conditions de fin de partie

---

## 🏆 Condition de victoire

La partie est gagnée lorsque le robot a déposé **une quantité suffisante de minerai** dans l’entrepôt.

La partie se termine si :
- le joueur quitte
- l’énergie du robot tombe à zéro

---

## 📐 Diagramme UML

Le diagramme UML du projet met en évidence :
- L’héritage entre `Case` et ses spécialisations
- L’association entre `Robot` et `Plateau`
- La composition du plateau contenant les cases

---

## 🛠️ Implémentation

- Langage : **Java**
- Interface : **console**
- Respect de la programmation orientée objet
- Une classe `Main` contient la méthode `main` pour lancer la simulation

---

## ▶️ Exécution du programme

```bash
javac *.java
java Main
