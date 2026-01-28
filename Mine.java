public class Mine extends Case {
    private int stockMinerai;

    public Mine(int stockInitial) {
        this.stockMinerai = stockInitial;
    }

    @Override
    public char afficher() {
        return stockMinerai > 0 ? 'M' : '.';
    }

    @Override
    public void interagir(Robot robot) {
        if (stockMinerai > 0) {
            System.out.println("Vous êtes sur une mine. Tentative d'extraction...");

            boolean aReussi = robot.collecter();

            if (aReussi) {
                stockMinerai--;
                System.out.println("Extraction réussie ! Il reste " + stockMinerai + " dans ce gisement.");
            }
        } else {
            System.out.println("Cette mine est épuisée, il n'y a plus rien ici.");
        }
    }

    @Override
    public boolean estFranchissable() {
        return true;
    }
}
