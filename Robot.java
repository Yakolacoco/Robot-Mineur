public class Robot {

    private String nom;
    private int x;
    private int y;
    private int mineraiTransporte;
    private int capaciteMax;
    private int energie;
    private static final int energieMax = 100;

    public Robot(String nom, int x, int y, int capaciteMax) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.capaciteMax = capaciteMax;
        this.mineraiTransporte = 0;
        this.energie = energieMax;
    }

    public void deplacer(int nouvelleX, int nouvelleY) {
        this.x = nouvelleX;
        this.y = nouvelleY;
        this.energie -= 5;
        if (energie < 0) energie = 0;
        System.out.println("Robot déplacé en : " + x + ", " + y);
    }

    public boolean collecter() {
        if (this.mineraiTransporte < this.capaciteMax) {
            this.mineraiTransporte++;
            this.energie -= 2;
            System.out.println("Minerai collecté !");
            return true;
        } else {
            System.out.println("Inventaire plein !");
            return false;
        }
    }

    public int deposer() {
        if (this.mineraiTransporte == 0) {
            System.out.println("Rien à déposer.");
            return 0;
        }
        int aDepose = this.mineraiTransporte;
        this.mineraiTransporte = 0;
        return aDepose;
    }

    public void reposer() {
        energie = energieMax;
        System.out.println("Robot reposé, énergie au max.");
    }

    public void afficherEtat() {
        System.out.println("Robot " + nom + " (" + x + "," + y + ") | Sac: " + mineraiTransporte + "/" + capaciteMax + " | Energie: " + energie);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getEnergie() { return energie; }
}
