package Question3;

public class Produit {

    private String name;
    private int number;
    private static int py =0;



    /* constructeur */
    public Produit(String NomProduit){
        this.name = NomProduit;
        this.number = ++py;
    }

    /* Méthode d'instance */
    public String getName(){

        System.out.println("Entrez le Nom du produit : ");
        py= py+1;
        return name;
    }

    /* Méthode d'instance */
    public String toString(){
        return "Prduit "+name+" à pour numéro "+number;
    }

    /* Méthode d'instance */
    public int getNumber() {
        return number;
    }

    public int getNumberCreated(){
        return py;
    }







}
