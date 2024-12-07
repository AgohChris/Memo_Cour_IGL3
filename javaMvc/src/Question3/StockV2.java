package Question3;

import java.util.Scanner;

class StockPleinException extends Exception {
    public StockPleinException(String message) {
        super(message);
    }
}

class StockVideException extends Exception {
    public StockVideException(String message) {
        super(message);
    }
}

public class StockV2 {

    private int taille;
    private Produit[] contenu;

    public StockV2(int tailleMax) {
        this.taille = 0;
        this.contenu = new Produit[tailleMax];
    }

    public void ajouter(Produit p) throws StockPleinException {
        if (estPlein()) {
            throw new StockPleinException("Le stock est plein.");
        }
        contenu[taille] = p;
        taille++;
    }

    public Produit retirer() throws StockVideException {
        if (estVide()) {
            throw new StockVideException("Le stock est vide.");
        }
        Produit produitRetire = contenu[taille - 1];
        contenu[taille - 1] = null;
        taille--;
        return produitRetire;
    }

    public boolean estVide() {
        return taille == 0;
    }

    public boolean estPlein() {
        return taille == contenu.length;
    }

    public int getTaille() {
        return taille;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Le stock contient ").append(taille).append(" produits:\n");
        for (int i = 0; i < taille; i++) {
            sb.append(contenu[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la taille maxi du stock : ");
        int tailleMax = scanner.nextInt();
        StockV2 stock = new StockV2(tailleMax);

        try {
            for (int i = 0; i < tailleMax; i++) {
                System.out.print("Entrez le nom du produit : ");
                String nomProduit = scanner.next();
                Produit p = new Produit(nomProduit);
                stock.ajouter(p);
                System.out.println("ajouté : " + p.toString());
            }

            System.out.println(stock.toString());

            System.out.println("Produit retiré : " + stock.retirer());

            System.out.println(stock.toString());

            System.out.println("Produit retiré : " + stock.retirer());


            stock.retirer();

        } catch (StockPleinException | StockVideException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
