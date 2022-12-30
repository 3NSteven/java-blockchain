import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        //VENDEUR
        System.out.println("Le vendeur...");
        Vendeur vendeur1 = new Vendeur();
        Enchere enchere1 = vendeur1.creerEnchere("Image", 100.50, 15, 360);


        ServerSocket server = null;
        Socket sock = null;
        PrintWriter sockOut = null;
        try {
            server = new ServerSocket(7770);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } /*finally {
            try {
                server.close();
            } catch (IOException e2) {
                System.err.println(e2.getMessage());
            }
        }*/
        while(true){
            try {
                sock = server.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

/*

        System.out.println(enchere1.getNomProduit());
        System.out.println(enchere1.getPrixInitial());
        if(enchere1.getMeilleureOffre() != null){   //si au moins une offre a été proposée pour cette enchère
            System.out.println(enchere1.getMeilleureOffre().getPrix());
        }
        System.out.println(enchere1.toString());

        System.out.println("Entrez le produit mis en vente:");
        String nomProduit = scanner.nextLine();
        System.out.println("Entrez le prix de départ (en euros):");
        double prix = 0;
        if(scanner.hasNextLine()){
            prix = scanner.nextDouble();
        }
        System.out.println("Entrez le temps avant le début de l'enchère (en minutes):");
        int tempsDepart = scanner.nextInt();
        System.out.println("Entrez la durée de l'enchère (en minutes):");
        int duree = scanner.nextInt();

        Enchere enchere2 = vendeur1.creerEnchere(nomProduit, prix, tempsDepart, duree);

        System.out.println(enchere2.toString());


        //ACHETEUR
        System.out.println("L'acheteur...");

        Acheteur acheteur1 = new Acheteur(8000);

        System.out.println("Choix de l'enchère: ");

        String idEnchereChoisie = scanner.nextLine();
        while(Market.getEnchereById(idEnchereChoisie) == null){ //si aucune enchère possédant cet ID n'est trouvée
            System.out.println(Market.listerEncheres());
            idEnchereChoisie = scanner.nextLine();
        }

        acheteur1.connexionEnchere(Market.getEnchereById(idEnchereChoisie));

        System.out.println("Vous êtes connecté à l'enchère suivante:\n");
        System.out.println(acheteur1.getEnchereSuivie().toString());

        double proposition = 0;
        while(true){
            System.out.println("Votre porte-feuille contient " + acheteur1.getFonds() + " euros.");
            if(acheteur1.getEnchereSuivie().hasOffre()){
                System.out.println("L'enchère la plus haute pour le produit " + acheteur1.getEnchereSuivie().getNomProduit() + " est de " + acheteur1.getEnchereSuivie().getMeilleureOffre().getPrix() + " euros.");
            }
            else{
                System.out.println("Le prix de départ pour le produit " + acheteur1.getEnchereSuivie().getNomProduit() + " est de " + acheteur1.getEnchereSuivie().getPrixInitial() + " euros.");
            }
            System.out.println("Indiquez le montant de l'enchérissement:");
            if(scanner.hasNextLine()){
                proposition = scanner.nextDouble();
            }
            acheteur1.envoyerOffre(proposition);
        }


        */
    }

}
