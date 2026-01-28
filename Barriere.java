public class Barriere extends Case {

    @Override
    public char afficher() {
        return 'B';
    }

    @Override
    public void interagir(Robot robot) {
        System.out.println("Impossible d'avancer, c'est bloquÃ© !");
    }

    @Override
    public boolean estFranchissable() {
        return false;
    }
}
