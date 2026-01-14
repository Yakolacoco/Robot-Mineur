import java.util.Random;

public class Plateau {

    private int largeur;
    private int hauteur;
    private Case[][] cases;
    private Robot robot;
    private Entrepot entrepot;

    public Plateau(int largeur, int hauteur, Robot robot) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.robot = robot;
        this.cases = new Case[hauteur][largeur];
        initialiserPlateau();
    }

    private void initialiserPlateau() {
        Random rand = new Random();

        // Remplir de cases vides
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                cases[y][x] = new CaseVide();
            }
        }

        // Placer l'entrepôt
        int ex = rand.nextInt(largeur);
        int ey = rand.nextInt(hauteur);
        entrepot = new Entrepot();
        cases[ey][ex] = entrepot;

        // Placer quelques mines
        for (int i = 0; i < 5; i++) {
            int x = rand.nextInt(largeur);
            int y = rand.nextInt(hauteur);
            if (cases[y][x] instanceof CaseVide) {
                cases[y][x] = new Mine(5);
            }
        }

        // Placer quelques barrières
        for (int i = 0; i < 5; i++) {
            int x = rand.nextInt(largeur);
            int y = rand.nextInt(hauteur);
            if (cases[y][x] instanceof CaseVide) {
                cases[y][x] = new Barriere();
            }
        }
    }

    public boolean estValide(int x, int y) {
        return x >= 0 && x < largeur && y >= 0 && y < hauteur;
    }

    public boolean estFranchissable(int x, int y) {
        if (!estValide(x, y)) return false;
        return cases[y][x].estFranchissable();
    }

    public Case obtenirCase(int x, int y) {
        if (!estValide(x, y)) return null;
        return cases[y][x];
    }

    public Entrepot getEntrepot() {
        return entrepot;
    }

    public void afficherPlateau() {
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                if (robot.getX() == x && robot.getY() == y) {
                    System.out.print("R ");
                } else {
                    System.out.print(cases[y][x].afficher() + " ");
                }
            }
            System.out.println();
        }
    }
}
