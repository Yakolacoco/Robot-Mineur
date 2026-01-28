public class Main {
    public static void main(String[] args) {
        Robot wallE = new Robot("Wall-E", 0, 0, 3);

        Plateau plateau = new Plateau(10, 10, wallE);

        Jeu jeu = new Jeu(plateau, wallE);

        jeu.demarrer();
    }
}
