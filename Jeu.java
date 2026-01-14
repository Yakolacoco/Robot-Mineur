import java.util.Scanner;

public class Jeu {

    private Plateau plateau;
    private Robot robot;
    private boolean enCours;
    private Scanner scanner;

    public Jeu(Plateau plateau, Robot robot) {
        this.plateau = plateau;
        this.robot = robot;
        this.enCours = true;
        this.scanner = new Scanner(System.in);
    }

    // affiche le début de la partie
    public void demarrer() {
        System.out.println("=== Début de la simulation ===");

        while (enCours) {
            plateau.afficherPlateau();
            robot.afficherEtat();
        // montre les commande pour se déplacer
            System.out.print("Commande (haut/bas/gauche/droite/repos/etat/quitter) : ");
            String commande = scanner.nextLine().toLowerCase();

            traiterCommande(commande);
            verifierFin();
        }
    // affiche la fin de la partie
        System.out.println("=== Fin de la partie ===");
    }

    private void traiterCommande(String commande) {
        int nx = robot.getX(); // cordonner de la largeur
        int ny = robot.getY(); // cordonner de la hauteur

        switch (commande) {
            case "haut":
                ny--; // on monte de une case
                break;
            case "bas":
                ny++; // on dessend d'une casse
                break;
            case "gauche":
                nx--; // on de déplace a gauche
                break;
            case "droite":
                nx++; // on de déplace a droite
                break;
            case "repos":
                robot.reposer(); // le rebot se repos
                return;
            case "etat":
                robot.afficherEtat(); // voir son état énergie
                return;
            case "quitter":
                enCours = false; // pour areter le jeu
                return;
            default:
                System.out.println("Commande inconnue.");
                return;
        }

        //il va donner les information des commande pour qui interagie au robot
        if (plateau.estFranchissable(nx, ny)) {
            robot.deplacer(nx, ny);
            Case c = plateau.obtenirCase(nx, ny);
            if (c != null) {
                c.interagir(robot);
            }
        } else {
            System.out.println("Déplacement impossible !");
        }
    }
    // affiche le robot qui a plus de énergie
    private void verifierFin() {
        if (robot.getEnergie() <= 0) {
            System.out.println("Le robot n'a plus d'énergie !");
            enCours = false;
        }

    // affiche la réusite de objetif
        if (plateau.getEntrepot().getMineraisTotal() >= 10) {
            System.out.println("Victoire ! Objectif atteint !");
            enCours = false;
        }
    }
}
