import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Vendeur vendeur1 = new Vendeur();
        Enchere enchere1 = vendeur1.creerEnchere("Image", 100, 15, 360);
        System.out.println(enchere1.getPrix());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le produit mis en vente:");
        String nomProduit = scanner.nextLine();
        System.out.println("Entrez le prix de départ (en euros):");
        int prix = scanner.nextInt();
        System.out.println("Entrez le temps avant le début de l'enchère (en minutes):");
        int tempsDepart = scanner.nextInt();
        System.out.println("Entrez la durée de l'enchère (en minutes):");
        int duree = scanner.nextInt();

        Enchere enchere2 = vendeur1.creerEnchere(nomProduit, prix, tempsDepart, duree);

        System.out.println(enchere2.getNomProduit());
        System.out.println(enchere2.getPrix()+" euros");
    }

}
