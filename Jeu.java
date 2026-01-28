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

    public void demarrer() {
        System.out.println("=== BIENVENUE DANS ROBOT MINEUR ===");
        System.out.println("Objectif : Déposer 10 minerais à l'entrepôt (E).");

        while (enCours) {
            plateau.afficherPlateau();

            System.out.print("\nCommande (haut/bas/gauche/droite/repos/etat/quitter) : ");
            String commande = scanner.nextLine().toLowerCase();

            traiterCommande(commande);
            verifierFin();
        }
        System.out.println("=== Fin de la partie ===");
    }

    private void traiterCommande(String commande) {
        int nx = robot.getX();
        int ny = robot.getY();

        switch (commande) {
            case "haut":    ny--; break;
            case "bas":     ny++; break;
            case "gauche":  nx--; break;
            case "droite":  nx++; break;
            case "repos":
                robot.reposer();
                return;
            case "etat":
                robot.afficherEtat();
                return;
            case "quitter":
                enCours = false;
                return;
            default:
                System.out.println("Commande inconnue.");
                return;
        }

        if (plateau.estFranchissable(nx, ny)) {
            robot.deplacer(nx, ny);
            Case c = plateau.obtenirCase(nx, ny);
            if (c != null) {
                c.interagir(robot);
            }
        } else {
            System.out.println("Impossible d'aller là (Mur ou hors limite).");
        }
    }

    private void verifierFin() {
        if (robot.getEnergie() <= 0) {
            System.out.println("Le robot n'a plus d'énergie. GAME OVER.");
            enCours = false;
        }

        if (plateau.getEntrepot().getMineraisTotal() >= 10) {
            System.out.println("\nBRAVO ! Vous avez recuperer 10 minerais ! VICTOIRE !");
            enCours = false;
        }
    }
}
