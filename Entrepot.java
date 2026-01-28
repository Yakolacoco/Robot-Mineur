public class Entrepot extends Case {
    private int totalStocke = 0;

    @Override
    public char afficher() {
        return 'E';
    }

    @Override
    public void interagir(Robot robot) {
        System.out.println("Arrivée à l'entrepôt !");
        int depose = robot.deposer();
        totalStocke += depose;
        System.out.println("Total sécurisé dans l'entrepôt : " + totalStocke);
    }

    @Override
    public boolean estFranchissable() {
        return true;
    }

    public int getMineraisTotal() {
        return totalStocke;
    }
}
