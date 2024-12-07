package Question3;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom du premier produit : ");
        String nomProduit1 = scanner.nextLine();
        Produit p1 = new Produit(nomProduit1);

        System.out.print("Entrez le nom du deuxième produit : ");
        String nomProduit2 = scanner.nextLine();
        Produit p2 = new Produit(nomProduit2);


        System.out.println(p1.toString());
        System.out.println(p2.toString());


        System.out.println("Nombre total de produits créés : " + p1.getNumberCreated());

        scanner.close();
    }
}
