package Question3;

import java.util.Scanner;

public class StockV1 {

    private int taille;
    private Produit[] contenu;

    public StockV1(int tailleMax) {
        this.taille = 0;
        this.contenu = new Produit[tailleMax];
    }

    public String ajouter(Produit p) {
        if (estPlein()) {
            return "Le stock est plein, impossible d'ajouter plus de produits.";
        }
        contenu[taille] = p;
        taille++;
        return "Produit ajouté : " + p.toString();
    }

    public Produit retirer() {
        if (estVide()) {
            return null;
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

        System.out.print("Entrez la taille maximale du stock : ");
        int tailleMax = scanner.nextInt();
        StockV1 stock = new StockV1(tailleMax);

        for (int i = 0; i < tailleMax; i++) {
            System.out.print("Entrez le nom du produit : ");
            String nomProduit = scanner.next();
            Produit p = new Produit(nomProduit);
            System.out.println(stock.ajouter(p));
        }

        System.out.println(stock.toString());

        System.out.println("Produit retiré : " + stock.retirer());


        System.out.println(stock.toString());

        scanner.close();
    }
}
