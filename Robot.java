import java.util.Scanner;

public class Robot {

    private String nom;
    private int x;
    private int y;
    private int mineraiTransporte;
    private int capaciteMax;
    private int energie;

    private static final int xDepart = 2;
    private static final int yDepart = 3;
    private static final int energieMax = 100;
    private static final int stockageMax = 3;

    private Scanner scanner = new Scanner(System.in);

    public Robot(String nom, int x, int y, int capaciteMax) {
        this.nom = nom;
        this.x = xDepart;
        this.y = yDepart;
        this.capaciteMax = stockageMax;
        this.mineraiTransporte = 0;
        this.energie = energieMax;
    }

    public void deplacer(String direction) {
        switch (direction) {
            case "D": x++; break;
            case "G": x--; break;
            case "B": y++; break;
            case "H": y--; break;
            default:
                System.out.println("Commande invalide !");
                return;
        }
        this.energie -= 10;
        if (energie < 0) energie = 0;
        System.out.println("Le robot c'est deplacé dans la direction choisie !");
    }

    public boolean collecter() {
        if (this.mineraiTransporte < this.capaciteMax) {
            this.mineraiTransporte++;
            System.out.println("Vous avez collectez un minerai ! ");
            return true;
        } else  {
            System.out.println("Votre inventaire est plein allez le videz ! ");
            return false;
        }
    }

    public int deposer() {
        if (this.mineraiTransporte == 0) {
            System.out.println("Vous n'avez aucun minerai à déposer.");
            return 0;
        }
        int aDepose = this.mineraiTransporte;
        System.out.println("Vous avez déposé " + aDepose + " minerais dans l'entrepôt.");
        this.mineraiTransporte = 0;
        return aDepose;
    }

    public void reposer() {
        energie = energieMax;
        System.out.println("Le robot s'est reposé. Énergie maximale : " + energie);
    }

    public void afficherEtat() {
        System.out.println("=== État du robot ===");
        System.out.println("Nom : " + nom);
        System.out.println("Position : (" + x + ", " + y + ")");
        System.out.println("Minerai transporté : " + mineraiTransporte + "/" + capaciteMax);
        System.out.println("Énergie : " + energie + "/" + energieMax);
        System.out.println("====================");
    }
}

